package hamidov.sardor.goodzone.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hamidov.sardor.goodzone.models.*
import hamidov.sardor.goodzone.retrofit.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFagmentViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val featuredList = MutableLiveData<FeaturedList>()
    val brands = MutableLiveData<Brands>()
    val discounts = MutableLiveData<Promo>()
    val products = MutableLiveData<List<Product>>()
    val errorMessage = MutableLiveData<String>()

    fun getFeaturesList() {
        val response = repository.getFeaturedList()
        response.enqueue(object : Callback<FeaturedList> {
            override fun onResponse(call: Call<FeaturedList>, response: Response<FeaturedList>) {
                featuredList.postValue(response.body())
            }

            override fun onFailure(call: Call<FeaturedList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }

    fun getBrands() {
        val response = repository.getBrands()
        response.enqueue(object : Callback<Brands> {
            override fun onResponse(call: Call<Brands>, response: Response<Brands>) {
                brands.postValue(response.body())
            }

            override fun onFailure(call: Call<Brands>, t: Throwable) {

            }

        })
    }

    fun getDiscounts() {
        val response = repository.getDiscounts(true)
        response.enqueue(object : Callback<Promo> {
            override fun onResponse(call: Call<Promo>, response: Response<Promo>) {
                discounts.postValue(response.body())
            }

            override fun onFailure(call: Call<Promo>, t: Throwable) {

            }
        })
    }

}