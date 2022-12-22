package com.example.ToDoAplicationOdev.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ToDoAplicationOdev.data.entity.Notlar;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface NotlarDao {
    @Query("SELECT * FROM not_id")
    Single<List<Notlar>> NotlariYukle();

    @Query("SELECT * FROM not_id WHERE not_id like '%' || :aramaKelime || '%'")
    Single<List<Notlar>> Ara(String aramaKelime);

    @Delete
    Completable Sil(Notlar notlar);

    @Insert
    Completable Kaydet(Notlar notlar);

    @Update
    Completable Guncelle(Notlar notlar);

}
