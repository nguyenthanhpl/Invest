package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.OrderDAO;
import com.example.invest.DAO.UserDAO;
import com.example.invest.DTO.OrderDTO;
import com.example.invest.Entity.Order;
import com.example.invest.Entity.User;
import com.example.invest.Repository.OrderRepository;
import com.example.invest.Repository.UserRepository;
import com.example.invest.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    public void create(OrderDTO orderDTO) {
        Order order = new Order();
        order.setDay(orderDTO.getDay());
        order.setValues(orderDTO.getValues());
        order.setDayLimit(orderDTO.getDayLimit());
        order.setProductType(order.getProductType());
        User user = new User();
        user.setId(order.getId());
        order.setUser(user);
        orderRepository.save(mapperOrder(order));
    }

    private OrderDAO mapperOrder(Order order){
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.setDay(order.getDay());
        orderDAO.setValue(order.getValues());
        orderDAO.setDayLimit(order.getDayLimit());
        orderDAO.setProductType(order.getProductType());
        UserDAO userDAO = userRepository.findById(order.getUser().getId()).orElseThrow(() -> new RuntimeException("User is valid"));
        orderDAO.setUserDAO(userDAO);
        return orderDAO;
    }
}
