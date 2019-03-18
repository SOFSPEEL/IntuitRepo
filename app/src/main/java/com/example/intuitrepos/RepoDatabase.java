package com.example.intuitrepos;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Repo.class}, version = 1)
public abstract class RepoDatabase extends RoomDatabase {
    public abstract RepoDao repoDao();
}
