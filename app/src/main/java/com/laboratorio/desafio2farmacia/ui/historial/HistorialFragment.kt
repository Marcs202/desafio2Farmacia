package com.laboratorio.desafio2farmacia.ui.medicamentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.laboratorio.desafio2farmacia.databinding.FragmentHistorialBinding


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
        /*
        val textView: TextView = binding.textHistorial
        medicamentosViewModel.text.observe(viewLifecycleOwner) {
            textView.text = "Fragment de historial"
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}