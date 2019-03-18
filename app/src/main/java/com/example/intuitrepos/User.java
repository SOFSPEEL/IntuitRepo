package com.example.intuitrepos;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int uid;


    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "desc")
    public String description;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;
}