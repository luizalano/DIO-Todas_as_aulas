package br.com.luigipietro.usandapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.luigipietro.usandapi.model.Product
import com.bumptech.glide.Glide

class ProductAdapter(private val context: Context, private val productList:List<Product>)
    : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false))

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item: Product = productList[position]
        holder.productName.text = item.prName
        holder.productPrice.text = item.prPriceL
        Glide.with(context).load(item.prImage).into(holder.productImage)
    }

    override fun getItemCount(): Int = productList.size
}

class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val productImage: ImageView = itemView.findViewById(R.id.prod_image)
    val productName: TextView = itemView.findViewById(R.id.product_name)
    val productPrice : TextView = itemView.findViewById(R.id.product_price)
}
