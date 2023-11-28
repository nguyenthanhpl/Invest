package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.RewardSalesDAO;
import com.example.invest.DTO.ClaimDTO;
import com.example.invest.DTO.RewardProductDTO;
import com.example.invest.DTO.RewardSalesDTO;
import com.example.invest.Entity.Order;
import com.example.invest.Entity.RewardProduct;
import com.example.invest.Entity.RewardSales;
import com.example.invest.Repository.RewardSalesRepository;
import com.example.invest.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RewardSalesServiceImpl extends RewardServiceAbs {


    @Autowired
    UserService userService;

    @Autowired
    SalesService salesService;

    @Autowired
    RewardSalesRepository rewardSalesRepository;

    public String create(Order order) {
        Double getAmount = order.getAmount();
        List<Long> parents = getTotalParentQualified(order);
        List<Long> parents50 = new ArrayList<>();
        List<Long> parents200 = new ArrayList<>();
        RewardSales.Type type = RewardSales.Type.Deposit;
        for (Long parent : parents) {
            Double totalPointParent = salesService.getTotalPoint(parent);
            if ( totalPointParent >= 50 && totalPointParent < 200) {
                parents50.add(parent);
            } else if (totalPointParent >= 200) {
                parents200.add(parent);
            }
        }
        if (parents50.size() != 0) {
            Integer totalParents = parents50.size();
            double present = ((0.05 * getAmount) / totalParents);
            for (Long parent : parents50) {
                RewardSales rewardSale = new RewardSales(order.getId(), parent, present,type);
                rewardSalesRepository.save(mapperRewardSales(rewardSale));
            }

        }
        if (parents200.size() != 0) {
//            Integer totalParents = parents50.size();
            double present = (0.05 * getAmount) / parents200.size();
            for (Long parent : parents200) {
                RewardSales rewardSale = new RewardSales(order.getId(), parent, present,type);
                rewardSalesRepository.save(mapperRewardSales(rewardSale));
            }

        }
        return "thanh cong";
    }

    @Override
    public String withdraw(ClaimDTO claimDTO) {
        Double balance = rewardSalesRepository.checkTotalPoint(claimDTO.getUserDTOId());
        RewardSales.Type type = RewardSales.Type.Withdraw;
        if (balance.longValue() !=0) {
            RewardSales rewardSales = new RewardSales(claimDTO.getUserDTOId(), balance, type);
            rewardSalesRepository.save(mapperRewardSales(rewardSales));
            return "thành Công";
        }
        return "thất bại";
    }

//    @Override
    public List<Long> getTotalParentQualified(Order order) {
        List<Long> totalParent = userService.getListParentById(order);
        List<Long> parentsQualified = new ArrayList<>();
        for (Long parent : totalParent) {
            String getAddRestPublic = userService.getPublicAddress(parent);
            Long child = userService.totalChild(getAddRestPublic);
            if (child >= 3) {
                parentsQualified.add(parent);
            }
        }
        return parentsQualified;
    }


    private RewardSalesDAO mapperRewardSales(RewardSales rewardSales) {
        if(rewardSales.getType().equals(RewardSales.Type.Deposit))
        {
            RewardSalesDAO.Type type = RewardSalesDAO.Type.Deposit;
            RewardSalesDAO rewardSalesDAO = new RewardSalesDAO(rewardSales.getProductId(), rewardSales.getUserId(), rewardSales.getAmount(), type);
            return rewardSalesDAO;
        }
        else{
            RewardSalesDAO.Type type = RewardSalesDAO.Type.Withdraw;
            RewardSalesDAO rewardSalesDAO = new RewardSalesDAO(rewardSales.getProductId(), rewardSales.getUserId(), rewardSales.getAmount(), type);
            return rewardSalesDAO;
        }

    }
}
