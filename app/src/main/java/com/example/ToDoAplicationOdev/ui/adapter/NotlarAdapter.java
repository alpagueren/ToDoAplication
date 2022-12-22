package com.example.ToDoAplicationOdev.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ToDoAplicationOdev.data.entity.Notlar;
import com.example.ToDoAplicationOdev.ui.fragment.AnasayfaFragmentDirections;
import com.example.ToDoAplicationOdev.ui.viewmodel.AnasayfaViewModel;
import com.example.kisileruygulamasi.R;
import com.example.kisileruygulamasi.databinding.CardTasarimBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class NotlarAdapter extends RecyclerView.Adapter<NotlarAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Notlar> notlarListesi;
    private AnasayfaViewModel viewModel;

    public NotlarAdapter(Context mContext, List<Notlar> notlarListesi, AnasayfaViewModel viewModel) {
        this.mContext = mContext;
        this.notlarListesi = notlarListesi;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding binding;
        public CardTasarimTutucu(CardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_tasarim,parent,false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Notlar not = notlarListesi.get(position);
        CardTasarimBinding t = holder.binding;
        t.setNotNesnesi(not);

        t.satirCard.setOnClickListener(view -> {
            AnasayfaFragmentDirections.NotDetayGecis gecis =
                    AnasayfaFragmentDirections.notDetayGecis(not);
            Navigation.findNavController(view).navigate(gecis);
        });

        t.imageViewSil.setOnClickListener(view -> {
            Snackbar.make(view,not.getNot()+" silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("EVET",view1 -> {
                        viewModel.sil(not.getNot_id());
                    }).show();
        });
    }

    @Override
    public int getItemCount() {
        return notlarListesi.size();
    }
}
