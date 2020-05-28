package org.ddmed.ris.Controller;

import org.ddmed.ris.model.Patient;
import org.ddmed.ris.model.User;
import org.ddmed.ris.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    public Iterable<User> users() {
        return userRepository.findAll();
    }

}
