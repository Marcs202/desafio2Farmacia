package com.laboratorio.desafio2farmacia.adapter;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.laboratorio.desafio2farmacia.R;
import com.laboratorio.desafio2farmacia.model.Compras;
import com.laboratorio.desafio2farmacia.model.Medicamentos;
import com.laboratorio.desafio2farmacia.ui.medicamentos.MedicamentosViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HistorialAdapter extends FirebaseRecyclerAdapter <Compras, HistorialAdapter.ViewHolder> {

    public  HistorialAdapter(@NonNull FirebaseRecyclerOptions<Compras> options){
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder)
}
