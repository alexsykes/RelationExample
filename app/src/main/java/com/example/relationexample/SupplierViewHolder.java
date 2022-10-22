package com.example.relationexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SupplierViewHolder extends RecyclerView.ViewHolder {
    private final TextView supplierIDItemView, supplierNameItemView;

    private SupplierViewHolder (View itemView) {
        super(itemView);
        supplierIDItemView = itemView.findViewById(R.id.supplierIDTextView);
        supplierNameItemView = itemView.findViewById(R.id.supplierNameTextView);
    }

    public void bind(Supplier supplier) {
        supplierIDItemView.setText(String.valueOf(supplier.getSupplierID()));
        supplierNameItemView.setText(supplier.getSupplierName());
    }
    static SupplierViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.supplier_item,parent,false);
        return new SupplierViewHolder(view);
    }
}
