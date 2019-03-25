package com.example.intuitrepos.views.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.intuitrepos.databinding.RepoRowBinding;
import com.example.intuitrepos.dto.Repo;
import com.example.intuitrepos.views.CallbackSelected;
import com.example.intuitrepos.views.adapters.ItemsAdapter;
import com.example.intuitrepos.views.viewholder.ItemViewHolder;
import com.example.intuitrepos.views.viewholder.RepoViewHolder;

public class ReposAdapter extends ItemsAdapter<Repo> {
    public ReposAdapter(CallbackSelected selectedItem) {
        super(selectedItem);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        RepoRowBinding repoRowBinding = inflateBinding(viewGroup);
        return new RepoViewHolder(repoRowBinding, callbackSelected);
    }
    @Override
    protected RepoRowBinding inflateBinding(@NonNull ViewGroup viewGroup) {
        return RepoRowBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
    }
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.bind(items.get(i), i);
    }
}
