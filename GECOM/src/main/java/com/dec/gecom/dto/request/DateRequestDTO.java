package com.dec.gecom.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class DateRequestDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
}