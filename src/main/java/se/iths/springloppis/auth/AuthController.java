package se.iths.springloppis.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.iths.springloppis.exception.CustomException;

@RestController
public class AuthController {

    @GetMapping
    public String homePage() {

      throw new CustomException("NAAAAAEJ");
    }

    @GetMapping("userportal")
    public String userPortal() {
        return "Welcome, you are now authenticated";
    }

    @GetMapping("adminportal")
    public String adminPortal() {
        return "Welcome admin!";
    }

}
