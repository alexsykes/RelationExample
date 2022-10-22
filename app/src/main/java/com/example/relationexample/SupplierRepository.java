package com.example.relationexample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SupplierRepository {
    private SupplierDao supplierDao;
    private LiveData<List<Supplier>> allSuppliers;

    SupplierRepository(Application application) {
        RelationDatabase db = RelationDatabase.getDatabase(application);
        supplierDao = db.supplierDao();
        allSuppliers = supplierDao.getSuppliers();
    }

    LiveData<List<Supplier>> getAllSuppliers() {
        return allSuppliers;
    }

    void insert(Supplier supplier) {
        RelationDatabase.databaseWriteExecutor.execute(() -> {
            supplierDao.insert(supplier);
        });
    }
}