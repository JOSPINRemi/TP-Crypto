package com.example.user_api.controller;

import com.example.user_api.entity.User;
import com.example.user_api.repository.UserRepository;
import com.example.user_api.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users")
public class UserAPIController {

    private final UserService userService;

    public UserAPIController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Mono<User> postUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<User> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Boolean> getUserByEmail(@RequestBody User user) {
        return userService.login(user);
    }
}
