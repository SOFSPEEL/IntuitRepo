package com.example.intuitrepos.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.dto.Repo;

@Database(entities = {Repo.class, Issue.class}, version = 2, exportSchema = false)
public abstract class RepoDatabase extends RoomDatabase {
    public abstract RepoDao repoDao();
}
