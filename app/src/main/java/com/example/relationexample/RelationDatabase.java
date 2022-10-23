package com.example.relationexample;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Product.class, Supplier.class}, version = 1, exportSchema = false)

public abstract class RelationDatabase extends RoomDatabase{

    public abstract ProductDao productDao();
    public abstract SupplierDao  supplierDao();
    public abstract ProductDetailDao  productDetailDao();

    private static volatile RelationDatabase INSTANCE;
    public static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static RelationDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (RelationDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RelationDatabase.class,"relation_database")
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                ProductDao productDao = INSTANCE.productDao();
                SupplierDao supplierDao = INSTANCE.supplierDao();
                productDao.deleteAll();
                supplierDao.deleteAll();

                Product product = new Product("Apples", 1);
                productDao.insert(product);
                product = new Product("Oranges", 1);
                productDao.insert(product);
                product = new Product("Bananas", 1);
                productDao.insert(product);
                product = new Product("Lemons", 1);
                productDao.insert(product);
                product = new Product("PG Tips", 2);
                productDao.insert(product);
                product = new Product("Lemon Tea", 2);
                productDao.insert(product);
                product = new Product("Lapsang Souchon", 2);
                productDao.insert(product);
                product = new Product("Mint with Chamomile", 2);
                productDao.insert(product);
                product = new Product("Cornflakes", 3);
                productDao.insert(product);
                product = new Product("Wholemeal flour", 3);
                productDao.insert(product);
                product = new Product("Black Pepper", 3);
                productDao.insert(product);
                product = new Product("Sirloin", 4);
                productDao.insert(product);
                product = new Product("Cream of Mushroom", 5);
                productDao.insert(product);
                product = new Product("Rump", 3);
                productDao.insert(product);
                product = new Product("Spring Vegetable", 4);
                productDao.insert(product);
                product = new Product("Chicken with Corn", 4);
                productDao.insert(product);

                Supplier supplier = new Supplier(("Sharbatly"));
                supplierDao.insert(supplier);
                supplier = new Supplier(("Lipton"));
                supplierDao.insert(supplier);
                supplier = new Supplier(("General Mills"));
                supplierDao.insert(supplier);
                supplier = new Supplier(("Barker's Farm"));
                supplierDao.insert(supplier);
                supplier = new Supplier(("Maggi"));
                supplierDao.insert(supplier);



            });
        }

    };
}
