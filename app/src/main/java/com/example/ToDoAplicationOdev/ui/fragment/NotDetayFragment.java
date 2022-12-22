package com.example.ToDoAplicationOdev.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ToDoAplicationOdev.data.entity.Notlar;
import com.example.ToDoAplicationOdev.ui.viewmodel.NotDetayViewModel;
import com.example.kisileruygulamasi.R;
import com.example.kisileruygulamasi.databinding.FragmentNotDetayBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NotDetayFragment extends Fragment {
    private FragmentNotDetayBinding binding;
    private NotDetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_not_detay, container, false);
        binding.setNotDetayToolbarBaslik("Kişi Detay");

        NotDetayFragmentArgs bundle = NotDetayFragmentArgs.fromBundle(getArguments());
        Notlar gelenKisi = bundle.getNot();
        binding.setNotNesnesi(gelenKisi);

        binding.setNotDetayFragment(this);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(NotDetayViewModel.class);
    }

    public void guncelle(int not_id,String not){
        viewModel.guncelle(not_id,not);
    }
}