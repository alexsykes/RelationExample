package com.example.relationexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Product product);

    @Query("DELETE FROM products")
    void deleteAll();

    @Query("SELECT * FROM products ORDER BY stocklevel DESC")
    LiveData<List<Product>> getProducts();

    @Query("UPDATE products SET stocklevel = stocklevel + 1 WHERE productID = :productID")
    void incrementStockLevel(int productID);

    @Query("UPDATE products SET stocklevel = stocklevel - 1 WHERE productID = :productID")
    void decrementStockLevel(int productID);

    @Query("SELECT products.*, suppliers.supplierName FROM products JOIN suppliers ON products.supplierID = suppliers.supplierID ORDER BY stocklevel DESC")
    LiveData<List<Product>> getProductDetails();
}