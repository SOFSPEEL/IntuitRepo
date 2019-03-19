package com.example.intuitrepos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Repo> repos);

    @Query("SELECT * from repo")
    LiveData<List<Repo>> fetchAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Repo repo);

}
