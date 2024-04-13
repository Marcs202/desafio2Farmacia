package com.laboratorio.desafio2farmacia.ui.carrito

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.laboratorio.desafio2farmacia.adapter.MedicamentoAdapter
import com.laboratorio.desafio2farmacia.databinding.FragmentCarritoBinding
import com.laboratorio.desafio2farmacia.ui.medicamentos.MedicamentosViewModel


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
            val adapter = MedicamentoAdapter(carrito)
            recyclerView.adapter = adapter
        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}