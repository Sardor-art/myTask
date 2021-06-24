package hamidov.sardor.goodzone.main.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hamidov.sardor.goodzone.databinding.HomeBrandItemBinding
import hamidov.sardor.goodzone.models.Brand
import hamidov.sardor.goodzone.models.Brands
import hamidov.sardor.goodzone.models.Product

class BrandAdapter : RecyclerView.Adapter<BrandViewHolder>() {
    var brands = mutableListOf<Brand>()

    fun setBrandList(brands: List<Brand>) {
        this.brands = brands.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomeBrandItemBinding.inflate(inflater, parent, false)
        return BrandViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        val brand = brands[position]
        Picasso.get().load(brand.image).into(holder.binding.ivBrand)
    }

    override fun getItemCount(): Int {
        return brands.size
    }
}

class BrandViewHolder(val binding: HomeBrandItemBinding) :
    RecyclerView.ViewHolder(binding.root)