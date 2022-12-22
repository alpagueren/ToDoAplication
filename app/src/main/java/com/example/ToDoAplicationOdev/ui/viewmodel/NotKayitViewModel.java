package com.example.ToDoAplicationOdev.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.ToDoAplicationOdev.data.repo.NotlarDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NotKayitViewModel extends ViewModel {
    private NotlarDaoRepository krepo;

    @Inject
    public NotKayitViewModel(NotlarDaoRepository krepo){
        this.krepo = krepo;
    }

    public void kaydet(String not){
        krepo.kaydet(not);
    }
}
