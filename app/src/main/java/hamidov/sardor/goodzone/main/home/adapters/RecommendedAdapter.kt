package hamidov.sardor.goodzone.main.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hamidov.sardor.goodzone.databinding.HomeFamousItemBinding
import hamidov.sardor.goodzone.models.Product

class RecommendedAdapter : RecyclerView.Adapter<RecommendedViewHolder>() {
    var products = mutableListOf<Product>()

    fun setProductList(products: List<Product>) {
        this.products = products.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomeFamousItemBinding.inflate(inflater, parent, false)
        return RecommendedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
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

class RecommendedViewHolder(val binding: HomeFamousItemBinding) :
    RecyclerView.ViewHolder(binding.root)