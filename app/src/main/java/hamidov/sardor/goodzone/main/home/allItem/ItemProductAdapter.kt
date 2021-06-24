package hamidov.sardor.goodzone.main.home.allItem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hamidov.sardor.goodzone.databinding.HomeFamousItemBinding
import hamidov.sardor.goodzone.models.Product

class ProductAdapter : RecyclerView.Adapter<ProductViewHolder>() {
    var products = mutableListOf<Product>()

    fun setProductList(products: List<Product>) {
        this.products = products.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomeFamousItemBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.binding.itemType.text = product.category.name
        holder.binding.nameItem.text = product.name
        holder.binding.itemPrice.text = product.price.price
        Picasso.get().load(product.image).into(holder.binding.ivFamousItem)
        holder.binding.tvOff.visibility = View.GONE
    }

    override fun getItemCount(): Int {
        return products.size
    }
}

class ProductViewHolder(val binding: HomeFamousItemBinding) :
    RecyclerView.ViewHolder(binding.root)