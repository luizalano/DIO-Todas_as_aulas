package br.com.luigipietro.vmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var mContador = MutableLiveData<String>().apply { value = "0" }

    public fun incrementaContador(){
        var cont = mContador.toString().toInt()
        if (cont == 5) cont = 0
        else cont++
        mContador.value = cont.toString()
    }
}