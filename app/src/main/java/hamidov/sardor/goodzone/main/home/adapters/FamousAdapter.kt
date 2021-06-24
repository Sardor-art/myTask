package hamidov.sardor.goodzone.main.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hamidov.sardor.goodzone.databinding.HomeFamousItemBinding
import hamidov.sardor.goodzone.models.Product

class FamousAdapter : RecyclerView.Adapter<FamousViewHolder>() {
    var products = mutableListOf<Product>()

    fun setProductList(products: List<Product>) {
        this.products = products.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamousViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomeFamousItemBinding.inflate(inflater, parent, false)
        return FamousViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FamousViewHolder, position: Int) {
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

class FamousViewHolder(val binding: HomeFamousItemBinding) :
    RecyclerView.ViewHolder(binding.root)