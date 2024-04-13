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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HistorialAdapter extends FirebaseRecyclerAdapter<Compras, HistorialAdapter.ViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public HistorialAdapter(@NonNull FirebaseRecyclerOptions<Compras> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull HistorialAdapter.ViewHolder holder, int position, @NonNull Compras model) {
        holder.CodigoCompra.setText("");
        holder.Total.setText("");
        holder.FechaCompra.setText("");
        holder.CodigoCompra.setText("Codigo: "+(model.getCodigo()));
        holder.Total.setText("Total: $"+String.valueOf( model.getCostoTotalCompra()));
        holder.FechaCompra.setText("Fecha: "+(model.getFecha()));
    }

    @NonNull
    @Override
    public HistorialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.view_single_compra,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView CodigoCompra, FechaCompra, Total;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            CodigoCompra = itemView.findViewById(R.id.lblCodCompra);
            FechaCompra = itemView.findViewById(R.id.lblFechaCompra);
            Total = itemView.findViewById(R.id.lblCostoCompra);
        }
    }
}
