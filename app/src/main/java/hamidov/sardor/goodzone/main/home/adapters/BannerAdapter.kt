package hamidov.sardor.goodzone.main.home.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.squareup.picasso.Picasso
import hamidov.sardor.goodzone.R
import hamidov.sardor.goodzone.models.PromoX


class MySliderAdapter(context: Context, mySliderLists: List<PromoX>, viewPager: ViewPager2) :
    RecyclerView.Adapter<MySliderAdapter.ViewHolder>() {
    private val mySliderLists: List<PromoX>
    private val mInflater: LayoutInflater
    private val viewPager: ViewPager2
    var context: Context


    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = mInflater.inflate(R.layout.home_sub_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder( holder: ViewHolder, position: Int) {
        val ob: PromoX = mySliderLists[position]
        Picasso.get().load(ob.preview_image).into(holder.myimage)

    }

    override fun getItemCount(): Int {
        return mySliderLists.size
    }

    inner class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {
        var myimage: ImageView


        init {
            myimage = itemView.findViewById(R.id.iv_banner)
        }
    }

    init {
        mInflater = LayoutInflater.from(context)
        this.mySliderLists = mySliderLists
        this.viewPager = viewPager
        this.context = context
    }
}
