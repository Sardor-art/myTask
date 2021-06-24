package hamidov.sardor.goodzone.main.home.allItem

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hamidov.sardor.goodzone.models.Promo
import hamidov.sardor.goodzone.models.PromoX

class ItemViewModel : ViewModel() {
    val promo = MutableLiveData<List<PromoX>>()

    fun setPromoList(list: List<PromoX>) {
        promo.postValue(list)
    }
}