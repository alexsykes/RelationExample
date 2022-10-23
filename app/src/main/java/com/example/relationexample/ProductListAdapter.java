package com.example.relationexample;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.Objects;

public class ProductListAdapter extends ListAdapter<ProductDetail, ProductViewHolder> {

    public ProductListAdapter(@NonNull DiffUtil.ItemCallback<ProductDetail> productItemCallback) {
        super(productItemCallback);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ProductViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductDetail product = getItem(position);
        holder.bind(product);
    }

    static class ProductDiff extends DiffUtil.ItemCallback<ProductDetail> {

        @Override
        public boolean areItemsTheSame(@NonNull ProductDetail oldItem, @NonNull ProductDetail newItem) {
            return true;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ProductDetail oldItem, @NonNull ProductDetail newItem) {
            return Objects.equals(oldItem, newItem);
        }
    }
}
