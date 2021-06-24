package hamidov.sardor.goodzone.retrofit

class MainRepository constructor(private val jsonPlaceHolderApi: JsonPlaceHolderApi) {
    fun getFeaturedList() = jsonPlaceHolderApi.getFeaturedList()
    fun getBrands() = jsonPlaceHolderApi.getBrands()
    fun getDiscounts( active:Boolean) = jsonPlaceHolderApi.getDiscounts(active)
    fun getCategory()=jsonPlaceHolderApi.getCategory()
    fun getCategory(search: String)=jsonPlaceHolderApi.getCategory(search)
}