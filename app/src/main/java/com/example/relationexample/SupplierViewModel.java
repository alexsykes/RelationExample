package com.example.relationexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SupplierViewModel  extends AndroidViewModel {

    private SupplierRepository supplierRepository;
    private final LiveData<List<Supplier>> allSuppliers;

    public SupplierViewModel(@NonNull Application application) {
        super(application);
        supplierRepository = new SupplierRepository(application);
        allSuppliers = supplierRepository.getAllSuppliers();
    }

    LiveData<List<Supplier>> getAllSuppliers() { return allSuppliers; }
    public void insert(Supplier supplier) { supplierRepository.insert(supplier);}
}
