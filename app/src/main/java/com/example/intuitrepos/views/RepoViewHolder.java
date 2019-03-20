package com.example.intuitrepos.views;

import android.support.annotation.NonNull;

import com.example.intuitrepos.databinding.RepoRowBinding;
import com.example.intuitrepos.dto.Repo;

public class RepoViewHolder extends ItemViewHolder<Repo> {
    private RepoRowBinding repoRowBinding;

    public RepoViewHolder(@NonNull RepoRowBinding repoRowBinding, ISelectedItem selectedItem) {
        super(repoRowBinding, selectedItem);
        this.repoRowBinding = repoRowBinding;
    }

    @Override
    public void bind(Repo item, int position) {
        repoRowBinding.setRepo(item);
        super.bind(item, position);
    }
}
