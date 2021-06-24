package hamidov.sardor.goodzone.main.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hamidov.sardor.goodzone.models.Categories
import hamidov.sardor.goodzone.retrofit.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel constructor(private val repository: MainRepository): ViewModel() {
    val category = MutableLiveData<Categories>()

    fun getCategoryList(){
        val response = repository.getCategory()
        response.enqueue(object : Callback<Categories> {
            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                category.postValue(response.body())
            }

            override fun onFailure(call: Call<Categories>, t: Throwable) {

            }

        })
    }
}