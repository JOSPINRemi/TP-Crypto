package com.example.user_api.service;

import com.example.user_api.entity.User;
import com.example.user_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<User> saveUser(User user) {
        return userRepository.save(user);
    }

    public Flux<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Mono<Boolean> login(User user) {
        Mono<User> userMono = userRepository.findByEmail(user.getEmail());
        if (userMono != null && userMono.doOnNext()){
            return true;
        }
        return false;
    }
}
