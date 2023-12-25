package com.dec.gecom.repo;

import com.dec.gecom.entity.Product;
import com.dec.gecom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
//    @Query(value = "SELECT prod FROM Product prod where prod.product_id=:id")
//    void deleteByProductId(Long id);
}
