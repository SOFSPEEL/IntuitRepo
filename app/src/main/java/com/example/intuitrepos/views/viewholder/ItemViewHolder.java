package com.example.intuitrepos.views.viewholder;

import android.databinding.ViewDataBinding;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;

import com.example.intuitrepos.views.CallbackSelected;

public abstract class ItemViewHolder<T extends Parcelable> extends RecyclerView.ViewHolder implements View.OnClickListener {


    protected ViewDataBinding binding;
    private CallbackSelected callbackSelected;
    private T item;

    private SparseBooleanArray selectedItems = new SparseBooleanArray();

    public ItemViewHolder(@NonNull ViewDataBinding binding, CallbackSelected callbackSelected) {
        super(binding.getRoot());
        this.binding = binding;
        this.callbackSelected = callbackSelected;

        View root = binding.getRoot();
        root.setOnClickListener(this);

    }

    public void bind(T item, int position) {
        this.item = item;

        binding.executePendingBindings();

    }

    @Override
    public void onClick(View view) {
        notifyAndSetSelection(view);

    }


    /**
     * callsback
     * @param view
     */
    private void notifyAndSetSelection(View view) {
        int adapterPosition = getAdapterPosition();

        if (selectedItems.get(adapterPosition, false)) {
            selectedItems.delete(adapterPosition);
            view.setSelected(false);
        }
        else {
            selectedItems.put(adapterPosition, true);
            view.setSelected(true);
        }

        callbackSelected.selected(item);
    }
}

