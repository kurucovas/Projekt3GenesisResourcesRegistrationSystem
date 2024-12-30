package genesis.demo.Controller;

import genesis.demo.Model.User;
import genesis.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") int id, @RequestParam(defaultValue = "false") boolean detail) {
      return userService.getUserById(id, detail);
    }

    @GetMapping
    public List<User> getAllUsers(@RequestParam(value = "detail", defaultValue = "false") boolean detail) {
        return userService.getAllUsers(detail);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody User updatedUser) {
        return userService.updateUser(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String id) {
        return userService.deleteUserById(id);
    }
}