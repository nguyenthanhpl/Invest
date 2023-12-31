package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.SalesDAO;
import com.example.invest.Entity.Order;
import com.example.invest.Entity.Sales;
import com.example.invest.Repository.SalesRepository;
import com.example.invest.Services.SalesService;
import com.example.invest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    UserService userService;

//    @Autowired
//    OrderService orderService;

    @Autowired
    SalesRepository salesRepository;

    @Override
    public void create(Order order) {
//        Long userId = orderService.findUserById(orderId);
        Sales sales1 = new Sales(order.getId(), order.getUserId(), order.getAmount());
        salesRepository.save(mapperSales(sales1));

        List<Long> parents = userService.getListParentById(order);
        for (Long parent : parents) {
            Sales sales = new Sales(order.getId(), parent, order.getAmount());
            salesRepository.save(mapperSales(sales));
        }
    }

    @Override
    public Double getTotalPoint(Long userId) {
        Double totalPoint = salesRepository.getTotalPoint(userId);
        return totalPoint;
    }

    private SalesDAO mapperSales(Sales sales) {
        SalesDAO salesDAO = new SalesDAO(sales.getAmount(), sales.getOrderId(), sales.getUserId());

        return salesDAO;
    }



}
