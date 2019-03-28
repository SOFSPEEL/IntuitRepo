package com.example.intuitrepos.repository;

import android.arch.lifecycle.LiveData;

import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.dto.Repo;
import com.example.intuitrepos.dto.Credentials;

import java.util.List;

public interface IRepository {
    void fetchRepos();

    void fetchIssues(int repoId, String repoName, int count);

    LiveData<List<Repo>> getRepos();

    LiveData<List<Issue>> getIssues(int repoId);

    void saveCredentials(String userName, String password);

    Credentials fetchCredentials();

    LiveData<String> getReposError();

    LiveData<String> getIssuesError();
}
