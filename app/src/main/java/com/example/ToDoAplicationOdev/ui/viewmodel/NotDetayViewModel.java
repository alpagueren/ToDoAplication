package com.example.ToDoAplicationOdev.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.ToDoAplicationOdev.data.repo.NotlarDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NotDetayViewModel extends ViewModel {
    private NotlarDaoRepository krepo;

    @Inject
    public NotDetayViewModel(NotlarDaoRepository krepo){
        this.krepo = krepo;
    }

    public void guncelle(int not_id,String not){
        krepo.guncelle(not_id,not);
    }
}
