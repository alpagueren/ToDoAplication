package com.example.ToDoAplicationOdev.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ToDoAplicationOdev.ui.viewmodel.NotKayitViewModel;
import com.example.kisileruygulamasi.R;
import com.example.kisileruygulamasi.databinding.FragmentNotKayitBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NotKayitFragment extends Fragment {
    private FragmentNotKayitBinding binding;
    private NotKayitViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_not_kayit, container, false);
        binding.setNotKayitToolbarBaslik("Not Kayıt");
        binding.setNotKayitFragment(this);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(NotKayitViewModel.class);
    }

    public void kaydet(String not){
        viewModel.kaydet(not);
    }
}