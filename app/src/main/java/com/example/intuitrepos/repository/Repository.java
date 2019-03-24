package com.example.intuitrepos.repository;

import android.arch.lifecycle.LiveData;
import android.content.SharedPreferences;

import com.example.intuitrepos.db.RepoDao;
import com.example.intuitrepos.db.RepoDatabase;
import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.dto.Repo;
import com.example.intuitrepos.network.RepoService;
import com.example.intuitrepos.dto.Creds;

import java.util.List;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements IRepository {

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    private final RepoDao repoDao;

    SharedPreferences prefs;
    private RepoService repoService;

    private Executor executor;


    public Repository(RepoService repoService, RepoDatabase repoDatabase, Executor executor, SharedPreferences preferences) {

        this.repoService = repoService;
        this.executor = executor;
        repoDao = repoDatabase.repoDao();

        this.prefs = preferences;
    }

    @Override
    public LiveData<List<Repo>> fetchRepos() {

        fetchAndInsertRepos();
        return repoDao.fetchAllRepos();
    }

    @Override
    public LiveData<List<Issue>> fetchIssues(int repoId, String repoName, int count) {

        for (int i = 1; i <= count; i++) {
            fetchIssue(repoId, repoName, i);
        }

        return repoDao.fetchAllIssues(repoId);
    }

    private void fetchIssue(int repoId, String repoName, int i) {
        executor.execute(() -> {
            repoService.getIssue(repoName, i).enqueue(new Callback<Issue>() {
                @Override
                public void onResponse(Call<Issue> call, Response<Issue> response) {
                    if (response.isSuccessful()) {
                        Issue issue = response.body();
                        issue.repoId = repoId;
                        insertIssue(issue);
                    }
                }

                @Override
                public void onFailure(Call<Issue> call, Throwable t) {

                }
            });
        });
    }

    private void insertIssue(Issue issue) {
        executor.execute(() -> {
            repoDao.insertIssue(issue);
        });
    }

    public void fetchAndInsertRepos() {

        executor.execute(() -> {

            repoService.getRepos().enqueue(new Callback<List<Repo>>() {
                @Override
                public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                    List<Repo> repos = response.body();
                    if (response.isSuccessful()) {
                        insertRepos(repos);
                    }

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

    @Override
    public void saveCreds(String userName, String password) {
        prefs.edit().putString(KEY_USERNAME, userName).putString(KEY_PASSWORD, password).apply();
    }

    @Override
    public Creds getCreds() {
        String username = prefs.getString(KEY_USERNAME, "");
        String password = prefs.getString(KEY_PASSWORD, "");
        return new Creds(username, password);
    }

    private void insertRepos(List<Repo> repos) {

        executor.execute(() -> {
            repoDao.insertAllRepos(repos);
        });
    }
}
