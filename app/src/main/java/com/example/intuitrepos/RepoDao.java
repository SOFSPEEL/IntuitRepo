package com.example.intuitrepos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RepoDao {

    @Insert
    void insertAll(List<Repo> repos);

    @Query("SELECT * from repo ORDER BY name ASC")
    LiveData<List<Repo>> fetchAll();
}
