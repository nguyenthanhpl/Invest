package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.OrderDAO;
import com.example.invest.DTO.OrderDTO;
import com.example.invest.Entity.Order;
import com.example.invest.Repository.OrderRepository;
import com.example.invest.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    @Autowired
    RewardProductService rewardProductService;

    @Autowired
    SalesService salesService;

    @Autowired
    RewardSalesService rewardSalesService;

    public void createOrder(OrderDTO orderDTO) {
        Order order = new Order(orderDTO.getAmount(), orderDTO.getDay(), orderDTO.getDayLimit(), orderDTO.getProductType(), orderDTO.getUid());
        OrderDAO orderDAO = orderRepository.save(mapperOrder(order));
        rewardProductService.create(mapperOrderDAO(orderDAO));
        salesService.create(mapperOrderDAO(orderDAO));
        rewardSalesService.rewardSharUser(mapperOrderDAO(orderDAO));
    }

    @Override
    public Order findById(Long id) {
        OrderDAO orderDAO = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order is valid"));
        return mapperOrderDAO(orderDAO);
    }

    @Override
    public Long findUserById(Long orderId) {
        return orderRepository.findIdUser(orderId);

    }

    @Override
    public Double getAmount(Long orderId) {
        return orderRepository.getAmount(orderId);
    }



    // lấy địa chỉ cha thông qua orderId

    private OrderDAO mapperOrder(Order order) {
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.setDay(order.getDay());
        orderDAO.setAmount(order.getAmount());
        orderDAO.setDayLimit(order.getDayLimit());
        orderDAO.setProductType(order.getProductType());

        orderDAO.setUserDAOId(order.getUserId());
        return orderDAO;
    }


    private Order mapperOrderDAO(OrderDAO orderDAO) {
//        User user = new User(orderDAO.getUserDAO().getId());
        Order order = new Order(orderDAO.getId(),orderDAO.getAmount(), orderDAO.getDay(), orderDAO.getDayLimit(), orderDAO.getProductType(), orderDAO.getUserDAOId());
        return order;
    }

}
