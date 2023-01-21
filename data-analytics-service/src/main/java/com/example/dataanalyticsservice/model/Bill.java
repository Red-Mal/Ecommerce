package com.example.dataanalyticsservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    private Long id;
  //private String name;
  //private  long duration;
    private Date billDate;
    private Long customerId;
    private List<ProductItem> productItems;

}