package com.example.relationexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SupplierDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Supplier supplier);

    @Query("DELETE FROM suppliers")
    void deleteAll();

    @Query("SELECT * FROM suppliers ORDER BY supplierName")
    LiveData<List<Supplier>> getSuppliers();
}
