package com.example.intuitrepos.repository;

import android.arch.lifecycle.LiveData;

import com.example.intuitrepos.dto.Repo;

import java.util.List;

public interface IRepository {
    LiveData<List<Repo>> fetchRepos();

    void insert(Repo repo);
}
