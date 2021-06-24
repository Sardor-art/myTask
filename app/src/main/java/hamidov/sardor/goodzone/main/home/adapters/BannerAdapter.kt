package hamidov.sardor.goodzone.main.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.squareup.picasso.Picasso
import hamidov.sardor.goodzone.R
import hamidov.sardor.goodzone.models.Promo
import hamidov.sardor.goodzone.models.PromoX

class BannerAdapter(var promo: ArrayList<PromoX>,val viewPager2: ViewPager2) :
    RecyclerView.Adapter<BannerAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView = itemView.findViewById(R.id.iv_banner)

        fun setImage(promo:PromoX){
            Picasso.get().load(promo.preview_image).into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_sub_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setImage(promo[position])
        if (position == promo.size - 2){
            viewPager2.post(runnable)
        }
    }

    override fun getItemCount(): Int = promo.size

    private var runnable:Runnable = Runnable {
        promo.addAll(promo)
        notifyDataSetChanged()
    }
}