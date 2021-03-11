package br.com.luigipietro.dio_imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ConstrainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constrain)
        setListeners()
    }

    private fun setListeners(){
        txtPeso.doAfterTextChanged()
    }
}