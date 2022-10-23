package com.example.relationexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDetailDao {
    @Query("SELECT products.productID, products.productName, products.stocklevel, suppliers.supplierName " +
            "FROM products, suppliers " +
            "WHERE products.supplierID = suppliers.supplierID ORDER BY stocklevel DESC")
    LiveData<List<ProductDetail>> getProductDetailList();
}

