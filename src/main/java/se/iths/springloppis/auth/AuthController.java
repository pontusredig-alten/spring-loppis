package se.iths.springloppis.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping
    public String homePage() {
        return "Welcome to the home page";
    }

    @GetMapping("userportal")
    public String userPortal() {
        return "Welcome, you are now authenticated";
    }
}
