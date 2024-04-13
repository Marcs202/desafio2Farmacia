package com.laboratorio.desafio2farmacia.ui.medicamentos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.laboratorio.desafio2farmacia.model.Medicamentos

class MedicamentosViewModel : ViewModel() {

    @kotlin.jvm.JvmField

    /*private val _text = MutableLiveData<String>().apply {
            value = "This is dashboard Fragment"
        }
    
        val text: LiveData<String> = _text*/
    var carrito = MutableLiveData<ArrayList<Medicamentos>>(ArrayList())
}