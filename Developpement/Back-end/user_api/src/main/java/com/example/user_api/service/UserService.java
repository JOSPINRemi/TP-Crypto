package com.example.user_api.service;

import com.example.user_api.entity.User;
import com.example.user_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    public Flux<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Mono<User> authenticate(String email, String password) {
        return userRepository.findByEmail(email)
                .flatMap(user -> {
                    if (password.equals(user.getPassword())) {
                        return Mono.just(user);
                    } else {
                        return Mono.error(new RuntimeException("Mot de passe incorrect"));
                    }
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Utilisateur non trouvé")));
    }
}
