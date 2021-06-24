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
private const val MIN_SCALE = 0.85f
private const val MIN_ALPHA = 0.5f

class ZoomOutPageTransformer : ViewPager2.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        view.apply {
            val pageWidth = width
            val pageHeight = height
            when {
                position < -1 -> { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    alpha = 0f
                }
                position <= 1 -> { // [-1,1]
                    // Modify the default slide transition to shrink the page as well
                    val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
                    val vertMargin = pageHeight * (1 - scaleFactor) / 2
                    val horzMargin = pageWidth * (1 - scaleFactor) / 2
                    translationX = if (position < 0) {
                        horzMargin - vertMargin / 2
                    } else {
                        horzMargin + vertMargin / 2
                    }

                    // Scale the page down (between MIN_SCALE and 1)
                    scaleX = scaleFactor
                    scaleY = scaleFactor

                    // Fade the page relative to its size.
                    alpha = (MIN_ALPHA +
                            (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
                }
                else -> { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    alpha = 0f
                }
            }
        }
    }
}