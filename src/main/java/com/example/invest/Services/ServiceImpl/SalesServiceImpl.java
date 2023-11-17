package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.SalesDAO;
import com.example.invest.Entity.Sales;
import com.example.invest.Repository.SalesRepository;
import com.example.invest.Services.OrderService;
import com.example.invest.Services.SalesService;
import com.example.invest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    SalesRepository salesRepository;

    @Override
    public void create(Long orderId) {
        Long userId = orderService.findUserById(orderId);
        Sales sales = new Sales(orderId, userId, orderService.getAmount(orderId));
        salesRepository.save(sales);
        while (userService.getParentAddress(userId).equals(null) == false) {
            Long idUserParent = userService.getParentAddressID(orderService.findUserById(orderId));
            userId = idUserParent;
            Sales fSales = new Sales(orderId, idUserParent, orderService.getAmount(orderId));
            salesRepository.save(fSales);

        }

    }

    private SalesDAO mapperSales(Sales sales) {
        SalesDAO salesDAO = new SalesDAO();

        return salesDAO;
    }

//    private Double countPoint(Long userId){
//        User user = userService.findById(userId);
//        Long totalChild = userService.totalChild(user.getParentAddress());
//        Double totalChildPoint = userService.totalChildPoint(user.getParentAddress());
//        if(totalChild >=3){
//            if(totalChildPoint >= 500000 && totalChildPoint <200000){
//
//            }
//        }
//        return Double.parseDouble("0");
//    }


}
