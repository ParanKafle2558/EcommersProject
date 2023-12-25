package com.dec.gecom.controller;


import com.dec.gecom.ecomservice.UserService;
import com.dec.gecom.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/api/v2")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){
        System.out.printf("user detail from UI"+ userRequest.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userRequest));
    }

    @GetMapping("/get/byId/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        System.out.printf("user id from url"+ userId);
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userId));
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    @DeleteMapping("/get/delete/{userId}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long userId){
        String message="";
//        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.deleteOrderById(orderId));
        message = userService.deleteProductById(userId) ? "Successfully deleted" : "cannot delete";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
