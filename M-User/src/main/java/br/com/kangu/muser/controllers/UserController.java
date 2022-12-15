package br.com.kangu.muser.controllers;

import br.com.kangu.muser.entities.User;
import br.com.kangu.muser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping()
    public User insertCategory(@RequestBody User user){
        return userRepository.save(user);
    }

}
