package genesis.demo.Model;
import com.fasterxml.jackson.annotation.JsonInclude;


public class User {

    private String id;
    private String name;
    private String surname;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String personID;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String uuid;

    public User(String id, String name, String surname, String personID, String uuid) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.personID = personID;
        this.uuid = uuid;
    }

    public User(String id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}