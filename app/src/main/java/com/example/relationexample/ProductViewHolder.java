package com.example.relationexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    private final TextView productIDItemView, productNameItemView, supplierNameTextItem, stocklevelItemView;
    private final ImageView incrementButton, decrementButton;

    private ProductViewHolder (View itemView) {
        super(itemView);
        productIDItemView = itemView.findViewById(R.id.productIDTextView);
        productNameItemView = itemView.findViewById(R.id.productNameTextView);
        supplierNameTextItem = itemView.findViewById(R.id.supplierNameTextItem);
        incrementButton = itemView.findViewById(R.id.addImageView);
        decrementButton = itemView.findViewById(R.id.subtractImageView);
        stocklevelItemView = itemView.findViewById(R.id.stocklevelTextView);
    }

    public void bind(Product product) {
        productIDItemView.setText(String.valueOf(product.getProductID()));
        productNameItemView.setText(product.getProductName());
        supplierNameTextItem.setText(product.getSupplierName());
        stocklevelItemView.setText(String.valueOf(product.getStocklevel()));
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                ((MainActivity) context).incrementStockLevel(product);
            }
        });
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                ((MainActivity) context).decrementStockLevel(product);
            }
        });
    }

    static ProductViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item,parent,false);
        return new ProductViewHolder(view);
    }
}
