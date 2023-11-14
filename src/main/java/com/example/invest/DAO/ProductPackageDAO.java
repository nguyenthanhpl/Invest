package com.example.invest.DAO;

import com.example.jhd.Entity.ProductPackage;

import java.util.HashMap;
import java.util.Map;

public class ProductPackageDAO {
    private Map<Integer, ProductPackage> productPackages = new HashMap<>();

    public void addProductPackage(ProductPackage productPackage) {
        int hashCode = productPackage.hashCode();
        productPackages.put(hashCode, productPackage);
    }

    public ProductPackage getProductPackage(int hashCode) {
        return productPackages.get(hashCode);
    }
}
