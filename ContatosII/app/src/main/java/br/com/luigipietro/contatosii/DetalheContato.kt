package br.com.luigipietro.contatosii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class DetalheContato : AppCompatActivity() {
    private var contato: Contato? = null

    companion object {
        const val EXTRA_CONTATO : String = "EXTRA_CONTATO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_contato)
        initToolbar()
        getExtras()
        bindViews()
    }

    private fun initToolbar(){
        val toolbar: Toolbar = findViewById<Toolbar>(R.id.toolbarDetalhe)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getExtras(){
        contato = intent.getParcelableExtra(EXTRA_CONTATO)
    }

    private fun bindViews(){
        findViewById<TextView>(R.id.tvNomeContatoDetalhe).text = contato?.nome
        findViewById<TextView>(R.id.tvTelefoneDetalhe).text = contato?.telefone
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}