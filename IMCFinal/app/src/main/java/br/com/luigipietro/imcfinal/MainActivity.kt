package br.com.luigipietro.imcfinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import kotlin.math.abs
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun torrada(texto:String){
        val duration = Toast.LENGTH_LONG // LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, texto, duration)
        toast.show()
    }

    private fun calculaImc(peso:Double, altura:Double):Double{
        if (altura > 0) {
            return (peso / (altura * altura))
        }
        return 0.0
    }

    private fun stringToDouble(texto:String, absoluto:Boolean):Double {
        var retorno: Double = 0.0

        try {
            retorno = texto.toString().toDouble()
        } catch (e: Exception) {
            retorno = 0.0
        }
        if (absoluto) retorno = abs(retorno)

        return retorno
    }

    private fun setListeners(){
        var peso:Double = 0.0
        var altura:Double = 0.0

        txtPeso.doAfterTextChanged {texto -> peso = stringToDouble(texto.toString(), true) }
        txtAltura.doAfterTextChanged { texto -> altura = stringToDouble(texto.toString(), absoluto = true)  }
        btnCalcula.setOnClickListener{
            torrada("Apertado o butão!")
            val imc = calculaImc(peso, altura)
            val dec = DecimalFormat("#.00")
            //val credits = dec.format(number)
            txtResultado.text = dec.format(imc)
        }

    }
}