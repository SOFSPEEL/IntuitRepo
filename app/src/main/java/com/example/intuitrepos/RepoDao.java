package com.example.intuitrepos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface RepoDao {

    @Insert
    void insertAll(Repo ...repos);
}
