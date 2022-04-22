package com.example.project1.Controllers.UserControllers;

import com.example.project1.Security.SecurityService;
import com.example.project1.repositories.AccessTokenRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class LoginController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    @PostMapping("/login")
    public String login(@RequestBody ObjectNode objectNode) {
        String email = objectNode.get("email").asText();
        String password = objectNode.get("password").asText();
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        AccessToken accessToken = new AccessToken(jwtUtils.generateJwtToken(userDetails), LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), user);
//        accessTokenRepository.save(accessToken);

        boolean loginResponse = securityService.login(email, password);
        if (loginResponse) {

            return "user login successful";
        }
        return "Not exist";
    }
    @PostMapping("/logout")
    public String logout(@RequestBody ObjectNode objectNode) {
        String email = objectNode.get("email").asText();
        String password = objectNode.get("password").asText();

        boolean logoutResponse = securityService.logout(email, password);
        if (logoutResponse) {

            return "user logout successful";
        }
        return "not exist";
    }

}

