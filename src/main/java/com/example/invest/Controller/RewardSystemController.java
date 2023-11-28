package com.example.invest.Controller;

import com.example.invest.DTO.ClaimDTO;
import com.example.invest.Services.ServiceImpl.RewardSystemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reward-system")
public class RewardSystemController {

    @Autowired
    RewardSystemImpl rewardService;

    @PostMapping("/withdraw")
    public String withdraw(@RequestBody ClaimDTO claimDTO) {

        return rewardService.withdraw(claimDTO);
    }


}
