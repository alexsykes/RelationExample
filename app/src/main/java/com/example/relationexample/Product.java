package com.example.relationexample;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int productID;

    @NonNull
    private String productName;

    private int supplierID;
    private int stocklevel;

    public Product(@NonNull String productName, int supplierID) {
        this.productName = productName;
        this.supplierID = supplierID;
        stocklevel = 0;
    }

    public int getProductID() {
        return productID;
    }

    @NonNull
    public String getProductName() {
        return productName;
    }

    public void setProductName(@NonNull String productName) {
        this.productName = productName;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getStocklevel() {
        return stocklevel;
    }

    public void setStocklevel(int stocklevel) {
        this.stocklevel = stocklevel;
    }
}
