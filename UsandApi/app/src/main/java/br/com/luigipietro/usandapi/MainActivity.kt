package br.com.luigipietro.usandapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.luigipietro.usandapi.R
import br.com.luigipietro.usandapi.api.MyRetrofit
import br.com.luigipietro.usandapi.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recycleProducts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleProducts = findViewById(R.id.recycler_products)
        recycleProducts.layoutManager = LinearLayoutManager(this)
        getData()
    }

    private fun getData(){
        val call: Call<List<Product>> = MyRetrofit.instance?.productApi()?.getProductApi() as Call<List<Product>>

        call.enqueue(object: Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                // val adapter = ProductAdapter(this@MainActivity, response.body().toList())
                val adapter = response.body()?.let { ProductAdapter(this@MainActivity, it.toList()) }
                recycleProducts.adapter = adapter
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t?.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}