package com.example.relationexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductViewModel  extends AndroidViewModel {

    private ProductRepository productRepository;
    private final LiveData<List<Product>> allProducts;
    private final LiveData<List<Product>> productDetails;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository = new ProductRepository(application);
        allProducts = productRepository.getAllProducts();
        productDetails = productRepository.getProductDetails();
    }

    LiveData<List<Product>> getAllProducts() { return allProducts; }
    LiveData<List<Product>> getProductDetails() { return productDetails; }

    public void insert(Product product) { productRepository.insert(product);}

    public void increment(Product product) {
        productRepository.increment(product);
    }

    public void decrement(Product product) {
        productRepository.decrement(product);
    }
}
