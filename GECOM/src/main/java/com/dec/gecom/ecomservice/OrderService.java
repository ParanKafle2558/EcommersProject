package com.dec.gecom.ecomservice;

import com.dec.gecom.constant.StatusConstant;
import com.dec.gecom.entity.EOrder;
import com.dec.gecom.entity.Product;
import com.dec.gecom.repo.OrderRepo;
import com.dec.gecom.repo.ProductRepo;
import com.dec.gecom.request.OrderRequest;
import com.dec.gecom.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userservice;

    public EOrder addOrder(OrderRequest orderRequest) {
        EOrder order = new EOrder();
        order.setUser(userservice.getUserById(Long.valueOf(orderRequest.getUserId())));
        order.setProduct(productService.getProductById(Long.valueOf(orderRequest.getProductId())));
        order.setQuantity(orderRequest.getQuantity());
        order.setOrderStatus(StatusConstant.PENDING);
        order.setOrderDate(new Date());
        orderRepo.save(order);
        return order;
    }

    public EOrder getProductById(Long orderId) {
        return orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("product Not Found"));
    }

    public List<EOrder> addOrder() {
        List<EOrder> orders = orderRepo.findAll();
        return orders;
    }
    public EOrder getOrderById(Long orderId){
        EOrder order =orderRepo.findById(orderId).orElseThrow(()->new RuntimeException("Order Not Found"));
        return order;
    }
    public boolean deleteOrderById(long orderId){

        orderRepo.findById(orderId).orElseThrow(()->new RuntimeException("Order  Not Found"));
        try
        {
            orderRepo.deleteById(orderId);
            System.out.println("inside try block");
            return true;
        }catch (Exception e)
        {
            System.out.println("inside catch block");
            return false;
        }
    }

    public int getCountOfSoldProductsByProductId(Long productId) {
        List<EOrder> orders = orderRepo.findByOrderStatus(StatusConstant.PENDING);

        int count = 0;
        for (EOrder order : orders) {
            if (order.getProduct().getProduct_id().equals(productId)) {
                count++;
            }
        }

        return count;
    }

    public int getCountOfSoldProductsByUserId(Long userId) {
        List<EOrder> orders = orderRepo.findByOrderStatus(StatusConstant.PENDING);

        // Filter orders based on the provided user ID
        int count = 0;
        for (EOrder order : orders) {
            if (order.getUser().getId().equals(userId)) {
                count++;
            }
        }
        return count;
    }
//    public List<EOrder> getOrdersByDate(Date orderDate) {
//        return orderRepo.findEOrderByOrderDate(orderDate);
//    }
    public ResponseEntity<?> getOrdersByDate(Date orderDate) {
        List<EOrder> orders = orderRepo.findEOrderByOrderDate(orderDate);
        if (orders.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Orders in the date");
        }
        return  ResponseEntity.status(HttpStatus.OK).body(orders);
    }

//   public void getCreationDate()
//   {
//       order.getCreatedOn()
//   }
}

