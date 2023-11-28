package com.example.invest;

import com.example.invest.DTO.RewardSalesDTO;
import com.example.invest.Repository.RewardSalesRepository;
import com.example.invest.Services.ServiceImpl.RewardSalesServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RewardSalesServiceTest {

    @Mock
    RewardSalesRepository rewardSalesRepository;
    @InjectMocks
    RewardSalesServiceImpl rewardSalesService;

//    @Test
//    public void test_unDeposit_reward_sales() {
//        RewardSalesDTO rewardSalesDTO = new RewardSalesDTO();
//        rewardSalesDTO.setAmount(200.0);
//        rewardSalesDTO.setUserDTOId(1L);
//
//        Mockito.when(rewardSalesRepository.checkTotalPoint(1L)).thenReturn(300.0);
//        String result = rewardSalesService.unDeposit(rewardSalesDTO);
//        assertEquals("thành Công", result);
//    }
}
