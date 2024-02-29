package com.example.user_api.controller;

import com.example.user_api.entity.User;
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
        return userService.createUser(user);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<User> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping(value = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/login")
    public Mono<User> login(@RequestBody User user) {
        return userService.authenticate(user.getEmail(), user.getPassword());
    }
}
