package com.example.relationexample;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class SupplierListAdapter extends ListAdapter<Supplier, SupplierViewHolder> {

    public SupplierListAdapter(@NonNull DiffUtil.ItemCallback<Supplier> supplierItemCallback) {
        super(supplierItemCallback);
    }

    @Override
    public SupplierViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return SupplierViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull SupplierViewHolder holder, int position) {
        Supplier supplier = getItem(position);
        holder.bind(supplier);
    }

    static class SupplierDiff extends DiffUtil.ItemCallback<Supplier> {

        @Override
        public boolean areItemsTheSame(@NonNull Supplier oldItem, @NonNull Supplier newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Supplier oldItem, @NonNull Supplier newItem) {
            return oldItem.equals(newItem);
        }
    }
}
