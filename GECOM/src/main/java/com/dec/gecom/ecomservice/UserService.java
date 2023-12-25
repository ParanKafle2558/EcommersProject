package com.dec.gecom.ecomservice;

import com.dec.gecom.entity.Product;
import com.dec.gecom.entity.User;
import com.dec.gecom.repo.UserRepo;
import com.dec.gecom.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User addUser(UserRequest userRequest){
       User user =  new User();
       user.setUserName(userRequest.getUserName());
       user.setEmail(userRequest.getEmail());
       user.setPassword(userRequest.getPassword());
        return userRepo.save(user);
    }

    public User getUserById(Long userId){
       return userRepo.findById(userId).orElseThrow(()->new RuntimeException("user Not Found"));
    }
    public List<User> getUsers(){
        return (List<User>)userRepo.findAll();
    }
    public boolean deleteProductById(long userId){

        userRepo.findById(userId).orElseThrow(()->new RuntimeException("product  Not Found"));
        try
        {
            userRepo.deleteById(userId);
            System.out.println("inside try block");
            return true;
        }catch (Exception e)
        {
            System.out.println("inside catch block");
            return false;
        }
    }
}
