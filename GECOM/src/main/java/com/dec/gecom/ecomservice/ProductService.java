package com.dec.gecom.ecomservice;

import com.dec.gecom.entity.Product;
import com.dec.gecom.entity.User;
import com.dec.gecom.repo.ProductRepo;
import com.dec.gecom.repo.UserRepo;
import com.dec.gecom.request.ProductRequest;
import com.dec.gecom.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product addProduct(ProductRequest productRequest){
        Product product =  new Product();
        product.setProductName(productRequest.getProductName());
        product.setPrice((double)productRequest.getProductPrice());
        return productRepo.save(product);
    }

    public Product getProductById(Long productId){
        return productRepo.findById(productId).orElseThrow(()->new RuntimeException("product Not Found"));
    }
    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public boolean deleteProductById(long productId){

        productRepo.findById(productId).orElseThrow(()->new RuntimeException("product  Not Found"));
        try
        {
            productRepo.deleteById(productId);
            System.out.println("inside try block");
            return true;
        }catch (Exception e)
        {
            System.out.println("inside catch block");
            return false;
        }
    }

}
