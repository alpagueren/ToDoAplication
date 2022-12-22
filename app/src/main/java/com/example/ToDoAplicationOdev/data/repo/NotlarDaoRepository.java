package com.example.ToDoAplicationOdev.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.ToDoAplicationOdev.data.entity.Notlar;
import com.example.ToDoAplicationOdev.room.NotlarDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NotlarDaoRepository {//DAO : Database Access Object
    private MutableLiveData<List<Notlar>> notlarListesi;
    private NotlarDao kdao;

    public NotlarDaoRepository(NotlarDao kdao) {
        this.kdao = kdao;
        notlarListesi = new MutableLiveData();
    }

    public MutableLiveData<List<Notlar>> getNotlarListesi(){
        return notlarListesi;
    }

    public void notlariYukle(){
        kdao.NotlariYukle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Notlar>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onSuccess(List<Notlar> notlars) {
                        notlarListesi.setValue(notlars);
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void kaydet(String not){
        Notlar yeniNot = new Notlar(0,not);
        kdao.Kaydet(yeniNot).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {}
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void guncelle(int not_id,String not){
        Notlar guncellenenNot = new Notlar(not_id,not);
        kdao.Guncelle(guncellenenNot).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {}
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void ara(String aramaKelimesi){
        kdao.Ara(aramaKelimesi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Notlar>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onSuccess(List<Notlar> notlars) {
                        notlarListesi.setValue(notlars);
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void sil(int not_id){
        Notlar silinenNot = new Notlar(not_id,"");
        kdao.Sil(silinenNot).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {
                        notlariYukle();
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }
}
