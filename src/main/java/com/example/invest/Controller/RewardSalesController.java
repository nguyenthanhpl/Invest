package com.example.invest.Controller;

import com.example.invest.DTO.RewardSalesDTO;
import com.example.invest.Services.RewardSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reward-sales")
public class RewardSalesController {


    @Autowired
    RewardSalesService rewardSalesService;

    @PostMapping("/withdraw")
    public String withdraw(@RequestBody RewardSalesDTO rewardSalesDTO){

        return  rewardSalesService.unDeposit(rewardSalesDTO);
    }
}
