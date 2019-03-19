package com.example.intuitrepos;

import android.arch.lifecycle.LiveData;

import java.util.List;

public interface IRepository {
    LiveData<List<Repo>> FetchRepos();


    void Insert(Repo repo);
}
