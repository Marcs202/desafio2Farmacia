package com.laboratorio.desafio2farmacia.ui.medicamentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.laboratorio.desafio2farmacia.databinding.FragmentHistorialBinding
import com.laboratorio.desafio2farmacia.model.Compras


class HistorialFragment : Fragment() {

    private var _binding: FragmentHistorialBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /*val medicamentosViewModel =
            ViewModelProvider(this).get(HistorialViewModel::class.java) */
        _binding = FragmentHistorialBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Compras")

        //configurando el recylcler
        val recyclerView = binding.recyclerViewHistorial
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val options = FirebaseRecyclerOptions.Builder<Compras>()
            .setQuery(myRef, Compras::class.java)
            .build()
        val adapter = Hist
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}