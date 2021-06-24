package hamidov.sardor.goodzone.common

import android.util.DisplayMetrics
import android.widget.Adapter
import hamidov.sardor.goodzone.main.home.adapters.FamousAdapter
import hamidov.sardor.goodzone.main.home.adapters.NewsAdapter
import hamidov.sardor.goodzone.main.home.adapters.PromotionsAdapter
import hamidov.sardor.goodzone.main.home.adapters.RecommendedAdapter
import hamidov.sardor.goodzone.models.Product
import hamidov.sardor.goodzone.models.Promo
import hamidov.sardor.goodzone.models.PromoX
import hamidov.sardor.goodzone.retrofit.JsonPlaceHolderApi

object Constants {
    var height = 1920
    var width = 1080
    val BASE_URL = "https://dev.goodzone.uz/"
    var jsonPlaceHolderApi: JsonPlaceHolderApi? = null
    var promotions: List<PromoX>? = null
    var famous: List<Product>? = null
    var newsList: List<Product>? = null
    var recommended: List<Product>? = null
}