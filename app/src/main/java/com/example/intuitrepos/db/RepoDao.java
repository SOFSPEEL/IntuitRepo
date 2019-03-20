package com.example.intuitrepos.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.dto.Repo;

import java.util.List;


@Dao
public interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllRepos(List<Repo> repos);

    @Query("SELECT * from repo")
    LiveData<List<Repo>> fetchAllRepos();

    @Query("SELECT * from issue WHERE repoId=:id")
    LiveData<List<Issue>> fetchAllIssues(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Repo repo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllIssues(List<Issue> issues);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertIssue(Issue issue);
}
