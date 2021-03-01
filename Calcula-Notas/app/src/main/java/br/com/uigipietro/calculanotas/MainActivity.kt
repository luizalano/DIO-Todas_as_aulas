package br.com.uigipietro.calculanotas

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcularrr:Button = btnCalcula
        val resultado:TextView = txtResultado

        btnCalcula.setOnClickListener{
            val valNota1:Int = Integer.parseInt(txtNota1.toString())
            val valNota2:Int = Integer.parseInt(txtNota2.toString())
            val valFaltas:Int = Integer.parseInt(txtNumeroFaltas.toString())

            val media:Int = (valNota1 + valNota2) / 2

            if (media >= 6 && valFaltas <= 10){
                txtResultado.setBackgroundColor(Color.CYAN)
                txtResultado.setText("Aluno APROVADO. Média " + media + " e " + txtNumeroFaltas.toString() + " faltas.")
            } else {
                txtResultado.setBackgroundColor(Color.parseColor("#FFCCFF"))
                txtResultado.setText("Aluno REPROVADO. Média " + media + " e " + txtNumeroFaltas.toString() + " faltas.")
            }
        }
        
    }
}