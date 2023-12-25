package com.dec.gecom.controller;

import com.dec.gecom.dto.request.LoginDto;
import com.dec.gecom.ecomservice.ProductService;
import com.dec.gecom.ecomservice.UserService;
import com.dec.gecom.entity.User;
import com.dec.gecom.repo.UserRepo;
import com.dec.gecom.request.ProductRequest;
import com.dec.gecom.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("product/api/v2")
public class ProductController {
    @Autowired
    UserRepo userRepository;

    @Autowired
    private ProductService productService;

    @PostMapping("create")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest){
        System.out.printf("user detail from UI"+ productRequest.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productRequest));
    }

    @GetMapping("/get/byId/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Long productId){
        System.out.printf("user id from url"+ productId);
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(productId));
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
    }

    @DeleteMapping("/get/delete/{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long productId){
        String message="";
//        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.deleteOrderById(orderId));
        message = productService.deleteProductById(productId) ? "Successfully deleted" : "cannot delete";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
//        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(loginDto.getUsername()));
//        if (user.isPresent() && user.get().getPassword().equals(loginDto.getPassword())) {
//            // Login successful
//            return ResponseEntity.ok("Login successful");
//        } else {
//            // Invalid credentials
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//    }

}
