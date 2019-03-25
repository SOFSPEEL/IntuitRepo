package com.example.intuitrepos.repository;

import android.arch.lifecycle.LiveData;

import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.dto.Repo;
import com.example.intuitrepos.dto.Credentials;

import java.util.List;

public interface IRepository {
    LiveData<List<Repo>> fetchRepos();

    LiveData<List<Issue>> fetchIssues(int repoId, String repoName, int count);

    void insert(Repo repo);


    void saveCredentials(String userName, String password);

    Credentials fetchCredentials();
}
