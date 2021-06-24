package hamidov.sardor.goodzone.main.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hamidov.sardor.goodzone.databinding.SearchItemBinding
import hamidov.sardor.goodzone.models.CategoryX

class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {
    var categories = mutableListOf<CategoryX>()

    fun setProductList(categories: List<CategoryX>) {
        this.categories = categories.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SearchItemBinding.inflate(inflater, parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val product = categories[position]
        holder.binding.tvName.text = product.name
        Picasso.get().load(product.image).into(holder.binding.ivItem)
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}

class SearchViewHolder(val binding: SearchItemBinding) :
    RecyclerView.ViewHolder(binding.root)