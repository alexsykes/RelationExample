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
    private final LiveData<List<ProductDetail>> productDetailsNew;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository = new ProductRepository(application);
        allProducts = productRepository.getAllProducts();
        productDetails = productRepository.getProductDetails();
        productDetailsNew = productRepository.getProductDetailsNew();
    }

    LiveData<List<Product>> getAllProducts() { return allProducts; }
    LiveData<List<Product>> getProductDetails() { return productDetails; }
    LiveData<List<ProductDetail>> getProductDetailsNew() { return productDetailsNew; }

    public void insert(Product product) { productRepository.insert(product);}

    public void increment(int product) {
        productRepository.increment(product);
    }

    public void decrement(int product) {
        productRepository.decrement(product);
    }
}
