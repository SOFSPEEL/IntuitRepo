package com.example.intuitrepos.views;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemsAdapter<T extends  Object > extends RecyclerView.Adapter<ItemViewHolder> {

    protected ISelectedItem selectedItem;
    protected List<T> items = new ArrayList<>();

    public ItemsAdapter(ISelectedItem selectedItem) {

        this.selectedItem = selectedItem;
    }

    protected abstract ViewDataBinding inflateBinding(@NonNull ViewGroup viewGroup);


    @Override
    public int getItemCount() {
        return items.size();
    }


    public void setItems(List<T> items) {

        this.items = items;
    }
}
