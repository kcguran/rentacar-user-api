package userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import userservice.security.CurrentUser;
import userservice.security.UserPrincipal;
import userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/my-profile")
    public String getAllUsers(@CurrentUser UserPrincipal currentUser){

        return "Başarılı";
    }
}
