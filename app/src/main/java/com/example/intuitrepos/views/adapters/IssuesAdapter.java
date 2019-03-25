package com.example.intuitrepos.views.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.intuitrepos.databinding.IssueRowBinding;
import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.views.CallbackSelected;
import com.example.intuitrepos.views.viewholder.IssueViewHolder;
import com.example.intuitrepos.views.viewholder.ItemViewHolder;

public class IssuesAdapter extends ItemsAdapter<Issue> {
    public IssuesAdapter(CallbackSelected callbackSelected) {
        super(callbackSelected);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        IssueRowBinding rowBinding = inflateBinding(viewGroup);
        return new IssueViewHolder(rowBinding, callbackSelected);
    }
    @Override
    protected IssueRowBinding inflateBinding(@NonNull ViewGroup viewGroup) {
        return IssueRowBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
    }
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.bind(items.get(i), i);
    }
}
