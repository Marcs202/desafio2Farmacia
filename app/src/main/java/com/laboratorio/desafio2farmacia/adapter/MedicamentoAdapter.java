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
import com.laboratorio.desafio2farmacia.model.Medicamentos;
import com.laboratorio.desafio2farmacia.ui.medicamentos.MedicamentosViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MedicamentoAdapter extends FirebaseRecyclerAdapter <Medicamentos, MedicamentoAdapter.ViewHolder >{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MedicamentoAdapter(@NonNull FirebaseRecyclerOptions<Medicamentos> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Medicamentos model) {
        holder.lblMedicamento.setText(holder.lblMedicamento.getText() +" " + (model.getCodigo()));
        holder.nombre.setText(holder.nombre.getText() +" " + model.getNombre());
        holder.cantidad.setText(holder.cantidad.getText() +" " +String.valueOf( model.getCantidad()) );
        holder.precio.setText(holder.precio.getText() +" " + String.valueOf(model.getPrecio()));
        Picasso.get().load(model.getUrlImagen()).into(holder.imagenMedicamento);

        holder.botonCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí obtienes el ViewModel y agregas el medicamento al carrito
                MedicamentosViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) v.getContext()).get(MedicamentosViewModel.class);
                ArrayList<Medicamentos> carrito = viewModel.carrito.getValue();
                carrito.add(model);  // Asegúrate de tener acceso al medicamento 'model' aquí
                viewModel.carrito.setValue(carrito);

                Toast toast = Toast.makeText(v.getContext()  ,"Medicamento agregado al carrito",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_single_medicamento,parent,false);

        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, precio, cantidad, lblMedicamento;
        ImageView imagenMedicamento;
        FloatingActionButton botonCarrito;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            
            nombre = itemView.findViewById(R.id.lblSingleNombre);
            precio = itemView.findViewById(R.id.lblSinglePrecio);
            cantidad = itemView.findViewById(R.id.lblSingleCantidad);
            lblMedicamento = itemView.findViewById(R.id.lblCodigoMedica);
            imagenMedicamento = itemView.findViewById(R.id.imagenMedicamento);
            botonCarrito = itemView.findViewById(R.id.btnAgregarAlCarrito);



        }
    }
}
