package com.example.invest;

import com.example.invest.DAO.SalesDAO;
import com.example.invest.Entity.Order;
import com.example.invest.Entity.Sales;
import com.example.invest.Repository.SalesRepository;
import com.example.invest.Repository.UserRepository;
import com.example.invest.Services.OrderService;
import com.example.invest.Services.ServiceImpl.OrderServiceImpl;
import com.example.invest.Services.ServiceImpl.SalesServiceImpl;
import com.example.invest.Services.ServiceImpl.UserServiceImpl;
import com.example.invest.Services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static net.bytebuddy.matcher.ElementMatchers.anyOf;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SalesServicesTests {

    @Mock
    SalesRepository salesRepository;

    @Mock
    UserService userService;

    @InjectMocks
    SalesServiceImpl salesService;
//    @InjectMocks
//    OrderServiceImpl orderService;
//    @InjectMocks
//    UserServiceImpl userService;

    @Test
    public void testCreate() {
        Order order = new Order(1L, 2L, 100.0);
        Sales sales = new Sales(order.getId(), order.getUserId(), order.getAmount());
        List<Long> parents = Arrays.asList(3L, 4L);

//        Mockito.when(userRepository.getParentAddress(order.getId())).thenReturn(parents.toString());

        Mockito.when(userService.getListParentById(order)).thenReturn(parents);

        Assertions.assertDoesNotThrow(() -> {
            salesService.create(order);
        });

//         Kiểm tra xem phương thức save của SalesRepository đã được gọi đúng số lần chưa
        Mockito.verify(salesRepository, Mockito.times(3)).save(ArgumentMatchers.any(SalesDAO.class));
    }
}
