package com.example.relationexample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductRepository {
    private ProductDao productDao;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<Product>> productDetails;

    ProductRepository(Application application) {
        RelationDatabase db = RelationDatabase.getDatabase(application);
        productDao = db.productDao();
        allProducts = productDao.getProducts();
        productDetails = productDao.getProductDetails();
    }

    LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }
    LiveData<List<Product>> getProductDetails() { return productDetails; }

    void insert(Product product) {
        RelationDatabase.databaseWriteExecutor.execute(() -> {
            productDao.insert(product);
        });
    }

    public void increment(Product product) {
        RelationDatabase.databaseWriteExecutor.execute(() -> {
            productDao.incrementStockLevel(product.getProductID());
        });
    }

    public void decrement(Product product) {
        RelationDatabase.databaseWriteExecutor.execute(() -> {
            productDao.decrementStockLevel(product.getProductID());
        });
    }


}
