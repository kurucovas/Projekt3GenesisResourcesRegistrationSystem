package genesis.demo.Controller;

import genesis.demo.Model.User;
import genesis.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/v1/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/v1/users/{id}")
    public User getUserById(@PathVariable("id") int id, @RequestParam(defaultValue = "false") boolean detail) {
      return userService.getUserById(id, detail);
    }

    @GetMapping("/v1/users")
    public List<User> getAllUsers(@RequestParam(value = "detail", defaultValue = "false") boolean detail) {
        return userService.getAllUsers(detail);
    }

    @PutMapping("/v1/user")
    public User updateUser(@RequestBody User updatedUser) {
        return userService.updateUser(updatedUser);
    }

    @DeleteMapping("/v1/user/{id}")
    public User deleteUser(@PathVariable("id") String id) {
        return userService.deleteUserById(id);
    }
}