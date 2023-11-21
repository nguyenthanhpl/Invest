package com.example.invest.Controller;

import com.example.invest.DTO.RewardProductDTO;
import com.example.invest.Services.RewardProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reward-product")
public class RewardProductController {

    @Autowired
    RewardProductService rewardProductService;
    @PostMapping("/un-deposit")
     public  String unDeposit(@RequestBody RewardProductDTO rewardProductDTO){
         return rewardProductService.unDeposit(rewardProductDTO);
     }
}
