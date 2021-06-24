package hamidov.sardor.goodzone.main.home.allItem

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hamidov.sardor.goodzone.databinding.SingleCountBinding
import hamidov.sardor.goodzone.models.PromoX
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class IteamAdapter : RecyclerView.Adapter<IteamViewHolder>() {
    var discounts = mutableListOf<PromoX>()

    fun setDiscountList(discounts: List<PromoX>) {
        this.discounts = discounts.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IteamViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SingleCountBinding.inflate(inflater, parent, false)
        return IteamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IteamViewHolder, position: Int) {
        val promo = discounts[position]
        Picasso.get().load(promo.preview_image).into(holder.binding.itemImage)
        holder.binding.itemName.text = promo.title
//        Locale.setDefault(Locale.FRANCE);
     /*   val formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.US);
        val start = LocalDate.parse(promo.formatted_start_date.toString().substring(0,10), formatter);
        val end = LocalDate.parse(promo.formatted_end_date.substring(0,10), formatter);
       holder.binding.itemDescriptions.text = "${formatter.format(start)} - ${formatter.format(end)}*/
                holder.binding.itemDescriptions.text = "${promo.formatted_start_date.substring(0,10)} - ${promo.formatted_end_date.substring(0,10)}"
    }

    override fun getItemCount(): Int {
        return discounts.size
    }
}

class IteamViewHolder(val binding: SingleCountBinding) :
    RecyclerView.ViewHolder(binding.root)