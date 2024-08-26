package dailycodebuffer.authservice.config;

import dailycodebuffer.authservice.entities.User;
import dailycodebuffer.authservice.repositories.UserRepositories;
import dailycodebuffer.authservice.services.JwtService;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration {

    @Autowired
    private UserRepositories userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


    public String addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User added successfully";
    }

    public String generateToken(User user){
        return jwtService.generateToken(user);
    }

    public Boolean validateToken(String token, User user){
        return jwtService.isTokenValid(token, user);
    }
}
