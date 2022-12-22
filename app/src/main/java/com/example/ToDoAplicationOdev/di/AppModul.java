package com.example.ToDoAplicationOdev.di;

import android.content.Context;

import androidx.room.Room;

import com.example.ToDoAplicationOdev.data.repo.NotlarDaoRepository;
import com.example.ToDoAplicationOdev.room.NotlarDao;
import com.example.ToDoAplicationOdev.room.VeriTabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModul {
    @Provides
    @Singleton
    public NotlarDaoRepository provideNotlarDaoRepository(NotlarDao kdao){
        return new NotlarDaoRepository(kdao);
    }

    @Provides
    @Singleton
    public NotlarDao proviceNotlarDao(@ApplicationContext Context context){
        VeriTabani vt = Room.databaseBuilder(context,VeriTabani.class,"notlar.db").createFromAsset("notlar.db").build();
        return vt.getNotlarDao();
    }
}
