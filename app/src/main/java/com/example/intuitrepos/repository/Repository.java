package com.example.intuitrepos.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.intuitrepos.db.RepoDao;
import com.example.intuitrepos.db.RepoDatabase;
import com.example.intuitrepos.dto.Repo;
import com.example.intuitrepos.network.RepoService;

import java.util.List;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements IRepository {

    private final RepoDao repoDao;
    private RepoService repoService;

    private Executor executor;

    @NonNull
    private LiveData<List<Repo>> liveData;

    public Repository(RepoService repoService, RepoDatabase repoDatabase, Executor executor) {

        this.repoService = repoService;
        this.executor = executor;
        repoDao = repoDatabase.repoDao();
    }

    @Override
    public LiveData<List<Repo>> fetchRepos() {

        init();
        return repoDao.fetchAll();
    }

    public void init() {

        executor.execute(() -> {

            repoService.getRepos().enqueue(new Callback<List<Repo>>() {
                @Override
                public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                    List<Repo> repos = response.body();

                    Insert(repos);

                }

                @Override
                public void onFailure(Call<List<Repo>> call, Throwable t) {

                }
            });
        });
    }


    @Override
    public void insert(Repo repo) {
        executor.execute(() -> {
            repoDao.insert(repo);
        });
    }

    private void Insert(List<Repo> repos) {

        executor.execute(() -> {
            repoDao.insertAll(repos);
        });
    }
}
