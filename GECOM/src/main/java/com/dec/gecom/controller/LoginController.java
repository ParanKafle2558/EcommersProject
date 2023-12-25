package com.dec.gecom.controller;

import com.dec.gecom.dto.request.LoginDto;
import com.dec.gecom.ecomservice.UserService;
import com.dec.gecom.entity.User;
import com.dec.gecom.repo.UserRepo;
import com.dec.gecom.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController

@RequestMapping("api/v2")

public class LoginController {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        Optional<User> user = Optional.ofNullable((userRepository.findByUserName(loginDto.getUsername())));
        if (user.isPresent() && user.get().getPassword().equals(loginDto.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){
//        System.out.printf("user detail from UI"+ userRequest.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userRequest));
    }
}