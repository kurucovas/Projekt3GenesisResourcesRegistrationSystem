package genesis.demo.Service;

import genesis.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.support.KeyHolder;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.springframework.jdbc.support.GeneratedKeyHolder;

@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
    }

    private boolean isPersonIDInTextFile(String personID, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split("\n");
                if (lineParts.length > 0 && lineParts[0].equals(personID)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    private boolean isPersonIDInDatabase(String personId) {
        String sql = "SELECT COUNT(*) FROM usersGR WHERE personID = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{personId}, Integer.class);
        return count != null && count == 1;
    }

    public User createUser(User user) {

        boolean isInFile = isPersonIDInTextFile(user.getPersonID(), "src/main/resources/DataPersonId.txt");
        boolean isInDatabase = isPersonIDInDatabase(user.getPersonID());
        if (isInFile && !isInDatabase) {

            String uuid = generateUUID();
            user.setUuid(uuid);

            String sql = "INSERT INTO usersGR (name, surname, personID, uuid) VALUES (?, ?, ?, ?)";

            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getName());
                ps.setString(2, user.getSurname());
                ps.setString(3, user.getPersonID());
                ps.setString(4, user.getUuid());
                return ps;
            },keyHolder);

            Number generatedId = keyHolder.getKey();
            if (generatedId != null) {
                user.setId(generatedId.toString());
            }
            return user;
        }
        return null;
    }

    private String generateUUID() {
        return java.util.UUID.randomUUID().toString();
    }

    public User getUserById(int id, boolean detail) {
        String sql = "SELECT * FROM genesis_resources_registration_system.usersGR WHERE id = " + id;
        try {
            User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
                public User mapRow(ResultSet result, int rowNum) throws SQLException {
                    User user = new User();
                    user.setId(String.valueOf(result.getInt("ID")));
                    user.setName(result.getString("Name"));
                    user.setSurname(result.getString("Surname"));
                    if (detail) {
                        user.setPersonID(result.getString("PersonID"));
                        user.setUuid(result.getString("Uuid"));
                    }
                    return user;
                }
            });
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    public List<User> getAllUsers(boolean detail) {
        List<User> out = jdbcTemplate.query("select * from genesis_resources_registration_system.usersGR", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet result, int rowNum) throws SQLException {
                User user = new User();
                user.setId(String.valueOf(result.getInt("ID")));
                user.setName(result.getString("Name"));
                user.setSurname(result.getString("Surname"));
                if (detail) {
                    user.setPersonID(result.getString("PersonID"));
                    user.setUuid(result.getString("Uuid"));
                }
                return user;
            }
        });
        return out;
    }

    public User updateUser(User updatedUser) {
        String sql = "UPDATE genesis_resources_registration_system.usersGR SET Name = ?, Surname = ? WHERE ID = ?";
        int rowsAffected = jdbcTemplate.update(
                sql,
                updatedUser.getName(),
                updatedUser.getSurname(),
                updatedUser.getId()
        );
        if (rowsAffected > 0) {
            return updatedUser;
        } else {
            return null;
        }
    }

    public User deleteUserById(String id) {
        String selectSql = "SELECT * FROM genesis_resources_registration_system.usersGR WHERE ID = ?";
        try {
            User user = jdbcTemplate.queryForObject(selectSql, new Object[]{id}, (result, rowNum) -> {
                User u = new User();
                u.setId(result.getString("ID"));
                u.setName(result.getString("Name"));
                u.setSurname(result.getString("Surname"));
                u.setPersonID(result.getString("PersonID"));
                u.setUuid(result.getString("Uuid"));
                return u;
            });
            String deleteSql = "DELETE FROM genesis_resources_registration_system.usersGR WHERE ID = ?";
            jdbcTemplate.update(deleteSql, id);
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}