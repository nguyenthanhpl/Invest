package com.example.invest;

import com.example.invest.DAO.RewardProductDAO;
import com.example.invest.DTO.RewardProductDTO;
import com.example.invest.Entity.Order;
import com.example.invest.Repository.RewardProductRepository;
import com.example.invest.Services.ServiceImpl.RewardProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RewardProductServiceTest {


    @Mock
    RewardProductRepository rewardProductRepository;
    @InjectMocks
    private RewardProductServiceImpl rewardProductService;

    @Test
    public void test_create_reward_product() {
        // Create a sample Order
        Order order = new Order(1L, 20.0, new Date(), new Date(), 1L, 1L);

        // Call the create method
        rewardProductService.create(order);

        // Verify that the repository's save method was called with the expected RewardProductDAO
        ArgumentCaptor<RewardProductDAO> captor = ArgumentCaptor.forClass(RewardProductDAO.class);
        Mockito.verify(rewardProductRepository).save(captor.capture());

        // Extract the captured RewardProductDAO
        RewardProductDAO savedDAO = captor.getValue();

        // Add your assertions here based on your implementation
        assertEquals(order.getAmount(), savedDAO.getPoint(), 0.001); // Using delta for double comparison
        assertEquals(order.getUserId(), savedDAO.getUserDAOId());
        assertEquals(order.getId(), savedDAO.getOrderDAOId());
        assertEquals("deposit", savedDAO.getType());
    }

    @Test
    public void test_create_unDeposit(){

        RewardProductDTO rewardProductDTO = new RewardProductDTO();
        rewardProductDTO.setUserDTOId(1L);
        rewardProductDTO.setPoint(50.0);

        Mockito.when(rewardProductRepository.checkTotalPoint(1L)).thenReturn(100.0);
        String result = rewardProductService.unDeposit(rewardProductDTO);
        assertEquals("thành Công", result);
//        Mockito.verify(rewardProductRepository, Mockito.times(1).save(any()))
    }
}

