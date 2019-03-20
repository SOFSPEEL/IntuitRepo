package com.example.intuitrepos.views;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.intuitrepos.databinding.IssueRowBinding;
import com.example.intuitrepos.databinding.RepoRowBinding;
import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.dto.Repo;

public class IssuesAdapter extends ItemsAdapter<Issue> {
    public IssuesAdapter(ISelectedItem selectedItem) {
        super(selectedItem);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        IssueRowBinding rowBinding = inflateBinding(viewGroup);
        return new IssueViewHolder(rowBinding, selectedItem);
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
