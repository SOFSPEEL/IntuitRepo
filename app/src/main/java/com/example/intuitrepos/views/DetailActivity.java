package com.example.intuitrepos.views;

import android.arch.lifecycle.ViewModel;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.intuitrepos.R;
import com.example.intuitrepos.databinding.IssueDetailBinding;

public abstract class DetailActivity<TViewModel extends ViewModel, TBinding extends ViewDataBinding> extends ActivityBase<TViewModel> implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBinding();
    }

    protected void setupBinding() {
        TBinding binding = DataBindingUtil.setContentView(this, getLayoutId());
        setupBinding(binding);
    }

    protected abstract int getLayoutId();

    protected abstract void setupBinding(TBinding binding);
}
