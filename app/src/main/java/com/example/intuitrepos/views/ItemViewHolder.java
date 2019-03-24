package com.example.intuitrepos.views;

import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;

public abstract class ItemViewHolder<T extends Parcelable> extends RecyclerView.ViewHolder implements View.OnClickListener {


    protected ViewDataBinding binding;
    private ISelectedItem selectedItem;
    private T item;

    private SparseBooleanArray selectedItems = new SparseBooleanArray();

    public ItemViewHolder(@NonNull ViewDataBinding binding, ISelectedItem selectedItem) {
        super(binding.getRoot());
        this.binding = binding;
        this.selectedItem = selectedItem;

        View root = binding.getRoot();
        root.setOnClickListener(this);

    }

    public void bind(T item, int position) {
        this.item = item;

        binding.executePendingBindings();

    }

    @Override
    public void onClick(View view) {
        int adapterPosition = getAdapterPosition();

        if (selectedItems.get(adapterPosition, false)) {
            selectedItems.delete(adapterPosition);
            view.setSelected(false);
        }
        else {
            selectedItems.put(adapterPosition, true);
            view.setSelected(true);
        }

        selectedItem.selected(item);

    }
}

