package com.dec.gecom.controller;

import com.dec.gecom.dto.request.DateRequestDTO;
import com.dec.gecom.ecomservice.OrderService;
import com.dec.gecom.ecomservice.ProductService;
import com.dec.gecom.entity.EOrder;
//import com.dec.gecom.exceptional.ErrorResponse;
//import com.dec.gecom.exceptional.OrderNotFound;
import com.dec.gecom.request.OrderRequest;
import com.dec.gecom.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("order/api/v2")

public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody OrderRequest orderRequest){
        System.out.printf("order detail from UI"+ orderRequest.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.addOrder(orderRequest));
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> createOrder(){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.addOrder());
    }
    @GetMapping("/get/soldProductsCount/byProductId/{productId}")
    public ResponseEntity<?> getCountOfSoldProductsByProductId(@PathVariable Long productId,@RequestBody OrderRequest orderRequest) {
        int count = orderService.getCountOfSoldProductsByProductId(productId);
        return ResponseEntity.status(HttpStatus.OK).body("Number of sold products for product ID " + productId + ": " + count);
    }
    @GetMapping("/get/soldProductsCount/byUserId/{userId}")
    public ResponseEntity<?> getCountOfSoldProductsByUserId(@PathVariable Long userId) {
        int count = orderService.getCountOfSoldProductsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body("Number of sold products for user ID " + userId + ": " + count);
    }
    @GetMapping("/get/{orderId}")
    public ResponseEntity<?> createOrder(@PathVariable Long orderId){
//        if(orderService.getOrderById(orderId) == null){
//            throw new OrderNotFound("Student id not found - " + orderId);
//        }
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.getOrderById(orderId));
    }
    @DeleteMapping("/get/delete/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderId){
        String message="";
//        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.deleteOrderById(orderId));
        message = orderService.deleteOrderById(orderId) ? "Successfully deleted" : "cannot delete";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    @PostMapping("/order/date")
    public ResponseEntity<?> getOrdersByDate(@RequestBody DateRequestDTO requestDTO) {
        return orderService.getOrdersByDate(requestDTO.getOrderDate());
    }
//    @ExceptionHandler
//    public ResponseEntity<ErrorResponse> handleException(OrderNotFound exc) {
//
//
//        ErrorResponse error = new ErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        // return ResponseEntity
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
}



    /*@GetMapping("/get/all")
    public ResponseEntity<?> createOrder(){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.addOrder());
    }*/