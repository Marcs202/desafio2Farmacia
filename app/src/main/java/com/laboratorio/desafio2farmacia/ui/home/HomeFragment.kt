package com.laboratorio.desafio2farmacia.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.laboratorio.desafio2farmacia.R
import com.laboratorio.desafio2farmacia.databinding.FragmentHomeBinding
import com.laboratorio.desafio2farmacia.ui.medicamentos.MedicamentosFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val navController = findNavController()
        // Agrega un OnClickListener al botón
        binding.btnFarmacia.setOnClickListener {
            // Navegar al MedicamentosFragment

            navController.navigate(R.id.action_navigation_home_to_navigation_medicamentos)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}