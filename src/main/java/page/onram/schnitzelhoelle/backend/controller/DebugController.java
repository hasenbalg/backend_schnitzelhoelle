package page.onram.schnitzelhoelle.backend.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {
    @GetMapping("/debugUser")
    public User getUser(Authentication authentication, Model model) {
        User u = (User) authentication.getPrincipal();
        return u;
    }
}
