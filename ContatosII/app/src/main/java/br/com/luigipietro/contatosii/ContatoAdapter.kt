package br.com.luigipietro.contatosii

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContatoAdapter(var listener: ClickItemContatoListner) : RecyclerView.Adapter<ContatoAdapter.ContatoAdapterViewHolder>() {

    private val list:MutableList<Contato> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoAdapterViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.contato_item, parent, false)
        return ContatoAdapterViewHolder(view, list, listener)
    }

    override fun onBindViewHolder(holder: ContatoAdapterViewHolder, position: Int) {
        /* liga cada view à lista de views */
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(list: List<Contato>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ContatoAdapterViewHolder (itemView: View, var list: List<Contato>, var listener: ClickItemContatoListner): RecyclerView.ViewHolder(itemView){
        /* Controla cada item (view) */
        private val tvNome : TextView = itemView.findViewById(R.id.txtNome)
        private val tvTelefone : TextView = itemView.findViewById(R.id.txtTelefone)
        private val ivImagem : ImageView = itemView.findViewById(R.id.imgImagem)

        init{
            itemView.setOnClickListener{
                listener.clickItemContato(list[adapterPosition])
            }
        }

        fun bind(contato: Contato){
            tvNome.text = contato.nome
            tvTelefone.text = contato.telefone
        }
    }
}