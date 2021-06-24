package hamidov.sardor.goodzone.main.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.squareup.picasso.Picasso
import hamidov.sardor.goodzone.databinding.HomePromotionsItemBinding
import hamidov.sardor.goodzone.models.BannerX
import hamidov.sardor.goodzone.models.Promo
import hamidov.sardor.goodzone.models.PromoX

class PromotionsAdapter : RecyclerView.Adapter<PromotionsViewHolder>() {
    var discounts = mutableListOf<PromoX>()

    fun setDiscountList(discounts: List<PromoX>) {
        this.discounts = discounts.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomePromotionsItemBinding.inflate(inflater, parent, false)
        return PromotionsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PromotionsViewHolder, position: Int) {
        val promo = discounts[position]
        Picasso.get().load(promo.preview_image).into(holder.binding.ivPromotions)
        holder.binding.tvName.text = promo.title
    }

    override fun getItemCount(): Int {
        return discounts.size
    }
}

class PromotionsViewHolder(val binding: HomePromotionsItemBinding) :
    RecyclerView.ViewHolder(binding.root)