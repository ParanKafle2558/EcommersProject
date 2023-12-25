package com.dec.gecom.request;

import com.dec.gecom.entity.Product;
import com.dec.gecom.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {
   private Integer quantity;
   private Integer userId;
   private Integer productId;

}
