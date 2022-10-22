package com.example.relationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ProductViewModel productViewModel;
    SupplierViewModel supplierViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        supplierViewModel = new ViewModelProvider(this).get(SupplierViewModel.class);

        RecyclerView productListRV = findViewById(R.id.productRV);
        final ProductListAdapter productListAdapter = new ProductListAdapter(new ProductListAdapter.ProductDiff());
        productListRV.setAdapter(productListAdapter);
        productListRV.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView supplierListRV = findViewById(R.id.supplierRV);
        final SupplierListAdapter supplierListAdapter = new SupplierListAdapter(new SupplierListAdapter.SupplierDiff());
        supplierListRV.setAdapter(supplierListAdapter);
        supplierListRV.setLayoutManager(new LinearLayoutManager(this));

        productViewModel.getAllProducts().observe(this, products -> {
            productListAdapter.submitList(products);
        });

        supplierViewModel.getAllSuppliers().observe(this, suppliers -> {
            supplierListAdapter.submitList(suppliers);
        });
    }

    public void incrementStockLevel(Product product) {
        productViewModel.increment(product);
    }

    public void decrementStockLevel(Product product) {
        productViewModel.decrement(product);
    }
}