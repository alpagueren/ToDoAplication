package com.example.ToDoAplicationOdev.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ToDoAplicationOdev.data.entity.Notlar;
import com.example.ToDoAplicationOdev.data.repo.NotlarDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {

    private NotlarDaoRepository krepo;
    public MutableLiveData<List<Notlar>> notlarListesi = new MutableLiveData<>();

    @Inject
    public AnasayfaViewModel(NotlarDaoRepository krepo){
        this.krepo = krepo;

        notlarıYukle();
        notlarListesi = krepo.getNotlarListesi();
    }

    public void ara(String aramaKelimesi){
        krepo.ara(aramaKelimesi);
    }

    public void sil(int not_id){
        krepo.sil(not_id);
    }

    public void notlarıYukle(){
        krepo.notlariYukle();
    }
}
