package br.com.luigipietro.appnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {
    lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSend = findViewById(R.id.btnNotifica)
        btnSend.setOnClickListener {
            this.mostraNotificacao("1234", "Cursinho de Kotlin", "Mensagem usada no teste de envio de mensagens do bootcamp da Digital Inovation ONE, a fim de aprender a desenvolver app's usando Kotlin para Android")
        }

        Log.i("########token do main", FirebaseInstanceId.getInstance().token.toString())
    }
}