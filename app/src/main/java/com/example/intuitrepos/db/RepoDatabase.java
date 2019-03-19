package com.example.intuitrepos.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.intuitrepos.dto.Repo;

@Database(entities = {Repo.class}, version = 1)
public abstract class RepoDatabase extends RoomDatabase {
    public abstract RepoDao repoDao();
}
