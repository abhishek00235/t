package dailycodebuffer.authservice.controller;

import dailycodebuffer.authservice.config.UserConfiguration;
import dailycodebuffer.authservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserConfiguration userConfiguration;

    @PostMapping("/add-user")
    public String addNewUser(@RequestBody User user) {
        return userConfiguration.addUser(user);
    }

    @GetMapping("/token")
    public String generateToken(User user){
      return userConfiguration.generateToken(user);
    }

    @GetMapping("/is-token-valid")
    public Boolean validateToken(@RequestParam("token") String token,
                                 User user){
        return userConfiguration.validateToken(token, user);
    }
}
