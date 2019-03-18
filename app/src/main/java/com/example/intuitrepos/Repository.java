package com.example.intuitrepos;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements IRepository {

    private RepoService repoService;
    private RepoDatabase repoDatabase;
    private Executor executor;

    @NonNull
    private MutableLiveData<List<Repo>> liveData = new MutableLiveData<>();

    public Repository(RepoService repoService, RepoDatabase repoDatabase, Executor executor) {

        this.repoService = repoService;
        this.repoDatabase = repoDatabase;
        this.executor = executor;
    }

    @Override
    public LiveData<List<Repo>> FetchRepos() {

        executor.execute(()-> {
            RepoDao repoDao = repoDatabase.repoDao();
            repoService.GetRepos().enqueue(new Callback<List<Repo>>() {
                @Override
                public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                    List<Repo> repos = response.body();


                    liveData.setValue(repos);

                    executor.execute(()->{
                        repoDao.insertAll(repos);
                    });
                }

                @Override
                public void onFailure(Call<List<Repo>> call, Throwable t) {

                }
            });
        });

        return liveData;

    }
}
