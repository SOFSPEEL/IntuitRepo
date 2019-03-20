package com.example.intuitrepos.views;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.intuitrepos.R;
import com.example.intuitrepos.databinding.RepoDetailBinding;
import com.example.intuitrepos.dto.Repo;
import com.example.intuitrepos.vm.RepoViewModel;

public abstract class DetailActivity<T extends Object> extends AppCompatActivity implements View.OnClickListener{
    private T repo;



}
