package com.example.invest.Controller;


import com.example.invest.Services.ServiceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    public ProductServiceImpl productService;


}
