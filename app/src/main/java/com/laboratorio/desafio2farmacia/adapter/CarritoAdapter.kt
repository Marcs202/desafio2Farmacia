package com.laboratorio.desafio2farmacia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.NumberPicker
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laboratorio.desafio2farmacia.R
import com.laboratorio.desafio2farmacia.model.Medicamentos
import com.squareup.picasso.Picasso

class CarritoAdapter(private val medicamentos: ArrayList<Medicamentos>) : RecyclerView.Adapter<CarritoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.lblSingleNombre)
        val precio: TextView = itemView.findViewById(R.id.lblSinglePrecio)
        val cantidad: TextView = itemView.findViewById(R.id.lblSingleCantidad)
        val lblMedicamento: TextView = itemView.findViewById(R.id.lblCodigoMedica)
        val imagenMedicamento: ImageView = itemView.findViewById(R.id.imagenMedicamento)
        val numberPicker : NumberPicker = itemView.findViewById(R.id.myNumberPicker);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_single_medicamento_carrito, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val medicamento = medicamentos[position]
        holder.lblMedicamento.text = holder.lblMedicamento.text.toString() + " " + medicamento.getCodigo()
        holder.nombre.text = holder.nombre.text.toString() + " " + medicamento.getNombre()
        holder.cantidad.text = holder.cantidad.text.toString() + " " + medicamento.getCantidad().toString()
        holder.precio.text = holder.precio.text.toString() + " " + medicamento.getPrecio().toString()
        holder.numberPicker.minValue = 1
        holder.numberPicker.maxValue = 10
        Picasso.get().load(medicamento.getUrlImagen()).into(holder.imagenMedicamento)
    }

    override fun getItemCount() = medicamentos.size
}
