package com.example.intuitrepos.views;

import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class ItemViewHolder<T extends Parcelable> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private int selected_position = -1;
    protected ViewDataBinding binding;
    private ISelectedItem selectedItem;
    private T item;

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

        binding.getRoot().setBackgroundColor(selected_position == position ? Color.LTGRAY : Color.TRANSPARENT);

    }

    @Override
    public void onClick(View view) {
        if (getAdapterPosition() == RecyclerView.NO_POSITION) return;

        // Updating old as well as new positions
//        notifyItemChanged(selected_position);
//        int newPosition = getAdapterPosition();
//        selected_position = newPosition;
//        notifyItemChanged(selected_position);
//todo:

        selectedItem.selected(item);


    }
}

