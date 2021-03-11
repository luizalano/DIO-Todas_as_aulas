package br.com.luigipietro.dio_imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
        /* finish() */
    }

    private fun seListeneres(){
        activity_main
    }


    override fun onStart() {
        super.onStart()
        Log.w("lifecycle", "metodo onStart -> A tela está visível")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecycle", "metodo onResume -> A tela está interagível")
    }

    override fun onPause() {
        Log.w("lifecycle", "metodo onPause -> A tela está pausível")
        super.onPause()
    }

    override fun onStop() {
        Log.w("lifecycle", "metodo onStop -> A tela está parada")
        super.onStop()
    }

    override fun onDestroy() {
        Log.w("lifecycle", "metodo onDestroy -> A tela está destruída")
        super.onDestroy()
    }
}