package com.example.relationexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductViewModel  extends AndroidViewModel {

    private ProductRepository productRepository;
    private final LiveData<List<Product>> allProducts;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository = new ProductRepository(application);
        allProducts = productRepository.getAllProducts();
    }

    LiveData<List<Product>> getAllProducts() { return allProducts; }
    public void insert(Product product) { productRepository.insert(product);}

    public void increment(Product product) {
        productRepository.increment(product);
    }

    public void decrement(Product product) {
        productRepository.decrement(product);
    }
}
