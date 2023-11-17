package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.OrderDAO;
import com.example.invest.DTO.OrderDTO;
import com.example.invest.Entity.Order;
import com.example.invest.Repository.OrderRepository;
import com.example.invest.Services.OrderService;
import com.example.invest.Services.RewardProductService;
import com.example.invest.Services.SalesService;
import com.example.invest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void create(OrderDTO orderDTO) {
//        User user = new User(orderDTO.getUid());
        Order order = new Order(orderDTO.getAmount(), orderDTO.getDay(), orderDTO.getDayLimit(), orderDTO.getProductType(), orderDTO.getUid());
        OrderDAO orderDAO = orderRepository.save(mapperOrder(order));
        rewardProductService.create(orderDAO.getId());
        salesService.create(orderDAO.getId());
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
        Order order = new Order(orderDAO.getAmount(), orderDAO.getDay(), orderDAO.getDayLimit(), orderDAO.getProductType(), orderDAO.getUserDAOId());
        return order;
    }

}
