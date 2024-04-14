package com.laboratorio.desafio2farmacia.ui.carrito

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.FirebaseDatabase
import com.laboratorio.desafio2farmacia.adapter.CarritoAdapter
import com.laboratorio.desafio2farmacia.adapter.MedicamentoAdapter
import com.laboratorio.desafio2farmacia.databinding.FragmentCarritoBinding
import com.laboratorio.desafio2farmacia.model.Compras
import com.laboratorio.desafio2farmacia.model.Medicamentos
import com.laboratorio.desafio2farmacia.ui.medicamentos.MedicamentosViewModel
import java.text.SimpleDateFormat
import java.util.Date


class CarritoFragment : Fragment() {

    private var _binding: FragmentCarritoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //val carritoViewModel =
        //  ViewModelProvider(this).get(CarritoViewModel::class.java)

        _binding = FragmentCarritoBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val medicamentosViewModel = ViewModelProvider(requireActivity()).get(MedicamentosViewModel::class.java)

        // Configura el RecyclerView
        val recyclerView = binding.recyclerViewCarrito
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Aquí observas los cambios en el carrito
        medicamentosViewModel.carrito.observe(viewLifecycleOwner, Observer { carrito ->
            // Aquí actualizas la UI con los medicamentos en el carrito
            // Puedes utilizar un adaptador similar a MedicamentoAdapter para mostrar los medicamentos en el RecyclerView
            val adapter = CarritoAdapter(carrito)
            recyclerView.adapter = adapter

            if (carrito.isEmpty()) {
                // Si el carrito está vacío, haz que el botón sea invisible
                binding.btnComprar.visibility = View.INVISIBLE
            } else {
                // Si el carrito no está vacío, haz que el botón sea visible
                binding.btnComprar.visibility = View.VISIBLE

                binding.btnComprar.setOnClickListener { realizarCompra(carrito,adapter) }
            }
        })




        return root
    }

    private  fun realizarCompra(carrito: List<Medicamentos>,adapter: CarritoAdapter ){
        // Itera sobre cada medicamento en el carrito

        val database = FirebaseDatabase.getInstance()
        val medicamentosRef = database.getReference("Medicamentos")
        val comprasRef = database.getReference("Compras")

        for (i in 0 until adapter.itemCount) {
            val medicamento = carrito[i]
            val cantidadSeleccionada = adapter.obtenerCantidadSeleccionada(i)
            val nuevaCantidad = medicamento.cantidad - cantidadSeleccionada

            if (nuevaCantidad >= 0) {
                // Actualizar la cantidad disponible del medicamento en la base de datos
                medicamentosRef.child(medicamento.codigo).child("Cantidad").setValue(nuevaCantidad)

                val fechaActual = System.currentTimeMillis()
                val costoTotal = medicamento.precio * cantidadSeleccionada
                val compra = Compras(
                    medicamento.codigo,
                    SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Date(fechaActual)),
                    costoTotal
                )

                // Agregar el registro de compra a la base de datos
                comprasRef.push().setValue(compra)
                    .addOnSuccessListener {
                        // La compra se registró correctamente
                        Toast.makeText(requireContext(), "Compra realizada con éxito", Toast.LENGTH_SHORT).show()

                        // Aquí puedes actualizar la interfaz de usuario según sea necesario
                    }
                    .addOnFailureListener { exception ->
                        // Se produjo un error al registrar la compra
                        Toast.makeText(requireContext(), "Error al realizar la compra", Toast.LENGTH_SHORT).show()
                        Log.e(TAG, "Error al realizar la compra", exception)
                    }
            } else {
                // No hay suficiente cantidad disponible para comprar este medicamento
                Toast.makeText(requireContext(), "No hay suficiente cantidad disponible para comprar ${medicamento.nombre}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun limpiarCarrito(){

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}