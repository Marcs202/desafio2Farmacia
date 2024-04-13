package com.laboratorio.desafio2farmacia.ui.medicamentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.laboratorio.desafio2farmacia.adapter.MedicamentoAdapter
import com.laboratorio.desafio2farmacia.databinding.FragmentMedicamentoBinding
import com.laboratorio.desafio2farmacia.model.Medicamentos

class MedicamentosFragment : Fragment() {

    private var _binding: FragmentMedicamentoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMedicamentoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inicializa la base de datos
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Medicamentos")

        // Configura el RecyclerView
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Configura las opciones para tu adaptador
        val options = FirebaseRecyclerOptions.Builder<Medicamentos>()
            .setQuery(myRef, Medicamentos::class.java)
            .build()

        // Inicializa el adaptador
        val adapter = MedicamentoAdapter(options)

        // Configura el adaptador para tu RecyclerView
        recyclerView.adapter = adapter

        // Inicia a escuchar cambios en los datos
        adapter.startListening()


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}