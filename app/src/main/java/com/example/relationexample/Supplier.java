package com.example.relationexample;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "suppliers")
public class Supplier {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    int supplierID;

    @NonNull
    private String supplierName;

    public Supplier(@NonNull String supplierName) {
        this.supplierName = supplierName;
    }

    public int getSupplierID() {
        return supplierID;
    }

    @NonNull
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(@NonNull String supplierName) {
        this.supplierName = supplierName;
    }
}
