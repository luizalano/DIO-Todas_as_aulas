package br.com.luigipietro.contatosii

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.luigipietro.contatosii.DetalheContato.Companion.EXTRA_CONTATO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : AppCompatActivity(), ClickItemContatoListner {
    private val rvList: RecyclerView by lazy { findViewById<RecyclerView>(R.id.rv_list) }
    private val adapter = ContatoAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)
        initDrawer()
        fetchListContato()
        bindView()
    }

    private fun fetchListContato(){
       val lista = arrayListOf(
            Contato("Luiz Alberto Alano", "41 99997-0486", ""),
            Contato("Daniel de Macedo Alano", "41 99677-7264", ""),
            Contato("Paula de Macedo Alano", "41 99677-7265", ""),
            Contato("Bundãozinho", "99677-7264", ""),
            Contato("Goiabinha", "99677-7265", ""),
            Contato("Kika", "41 99997-0486", "")
        )

        getInstanceSharedPreferences().edit() {
            putString("contatos",Gson().toJson(lista))
            apply()
            /*
            poderia ser commit()
            apply executa o "commit" de maneira assincrona, em nova thread
            */

        }
    }

    private fun getInstanceSharedPreferences(): SharedPreferences{
        return getSharedPreferences("com.br.luigipietro.contatosii.preferencias", Context.MODE_PRIVATE)
    }

    private fun initDrawer(){
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layoute)
        val toolbar: Toolbar = findViewById<Toolbar>(R.id.mainToolBar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun getListaContatos():List<Contato>{
        val lista = getInstanceSharedPreferences().getString("contatos", "[]")
        val tipoDoRetorno = object: TypeToken<List<Contato>>(){}.type
        return Gson().fromJson(lista, tipoDoRetorno)
    }

    private fun bindView(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        updateList()
    }

    private fun updateList(){
        adapter.updateList(getListaContatos())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_menu_1 -> {
                showToast("Exibindo Item de Menu 1")
                true
            }
            R.id.item_menu_2 -> {
                showToast("Exibindo Item de Menu 2")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun clickItemContato(contato: Contato) {
        val intent = Intent(this, DetalheContato::class.java)
        intent.putExtra(EXTRA_CONTATO, contato)
        startActivity(intent)
    }
}
