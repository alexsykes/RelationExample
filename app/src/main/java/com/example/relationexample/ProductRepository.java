package com.example.relationexample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductRepository {
    private ProductDao productDao;
    private ProductDetailDao productDetailDao;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<Product>> productDetails;
    private LiveData<List<ProductDetail>> productDetailsNew;

    ProductRepository(Application application) {
        RelationDatabase db = RelationDatabase.getDatabase(application);
        productDao = db.productDao();
        productDetailDao = db.productDetailDao();
        allProducts = productDao.getProducts();
        productDetails = productDao.getProductDetails();
        productDetailsNew = productDetailDao.getProductDetailList();
    }

    LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }
    LiveData<List<Product>> getProductDetails() { return productDetails; }
    LiveData<List<ProductDetail>> getProductDetailsNew() { return productDetailsNew;  }

    void insert(Product product) {
        RelationDatabase.databaseWriteExecutor.execute(() -> {
            productDao.insert(product);
        });
    }

    public void increment(int productID) {
        RelationDatabase.databaseWriteExecutor.execute(() -> {
            productDao.incrementStockLevel(productID);
        });
    }

    public void decrement(int productID) {
        RelationDatabase.databaseWriteExecutor.execute(() -> {
            productDao.decrementStockLevel(productID);
        });
    }


}
