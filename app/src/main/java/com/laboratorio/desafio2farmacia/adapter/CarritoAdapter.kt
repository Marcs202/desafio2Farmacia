package com.laboratorio.desafio2farmacia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.NumberPicker
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laboratorio.desafio2farmacia.R
import com.laboratorio.desafio2farmacia.model.Medicamentos
import com.squareup.picasso.Picasso

class CarritoAdapter(private val medicamentos: ArrayList<Medicamentos>) : RecyclerView.Adapter<CarritoAdapter.ViewHolder>() {
    private val valoresSeleccionados = mutableMapOf<Int, Int>() // Mapa para almacenar el valor seleccionado del NumberPicker

    // Otros métodos del adaptador...

    fun actualizarCantidadSeleccionada(position: Int, cantidad: Int) {
        valoresSeleccionados[position] = cantidad
    }

    fun obtenerCantidadSeleccionada(position: Int): Int {
        return valoresSeleccionados[position] ?: 0 // Si no hay un valor seleccionado, devuelve 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.lblSingleNombre)
        val precio: TextView = itemView.findViewById(R.id.lblSinglePrecio)
        val cantidad: TextView = itemView.findViewById(R.id.lblSingleCantidad)
        val lblMedicamento: TextView = itemView.findViewById(R.id.lblCodigoMedica)
        val numberPicker : NumberPicker = itemView.findViewById(R.id.myNumberPicker)

        init {
            numberPicker.setOnValueChangedListener { _, _, newValue ->
                // Actualiza la cantidad seleccionada del medicamento
                actualizarCantidadSeleccionada(adapterPosition, newValue)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_single_medicamento_carrito, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.lblMedicamento.text = ""
        holder.nombre.text = ""
        holder.cantidad.text = ""
        holder.precio.text = ""


        val medicamento = medicamentos[position]
        holder.lblMedicamento.text = "Codigo: " + medicamento.getCodigo()
        holder.nombre.text = "Farmaco: " + medicamento.getNombre()
        holder.cantidad.text = "Cantidad seleccionada: "
        holder.precio.text = "Precio:  $" + medicamento.getPrecio().toString()
        holder.numberPicker.minValue = 1
        holder.numberPicker.maxValue = 10

    }

    override fun getItemCount() = medicamentos.size
}
