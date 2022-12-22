package com.example.ToDoAplicationOdev.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "not_id")
public class Notlar implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "not_id")
    @NonNull
    private int not_id;
    @ColumnInfo(name = "not")
    @NonNull
    private String not;

    public Notlar() {
    }

    public Notlar(int not_id, @NonNull String not) {
        this.not_id = not_id;
        this.not = not;
    }

    public int getNot_id() {
        return not_id;
    }

    public void setNot_id(int not_id) {
        this.not_id = not_id;
    }

    @NonNull
    public String getNot() {
        return not;
    }

    public void setNot(@NonNull String not) {
        this.not = not;
    }
}
