package com.everis.listadecontatos.helpers

import android.content.SharedPreferences
import com.everis.listadecontatos.feature.listacontatos.model.ContatosVO

class ContatoHelper (private val sharedPreferences: SharedPreferences){
    fun getListContatos():List<ContatosVO>{
        return arrayListOf()
    }
    fun setListContatos(list:ContatosVO){

    }
}