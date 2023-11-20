package com.example.invest.Controller;

import com.example.invest.DTO.OrderDTO;
import com.example.invest.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @PostMapping("/create")
    public String createOrder(@RequestBody OrderDTO orderDTO){

        orderService.createOrder(orderDTO);
        return "Thanh cong";
    }
}
