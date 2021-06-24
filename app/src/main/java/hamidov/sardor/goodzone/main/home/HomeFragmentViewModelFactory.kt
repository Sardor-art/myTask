package hamidov.sardor.goodzone.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hamidov.sardor.goodzone.models.FeaturedList
import hamidov.sardor.goodzone.retrofit.JsonPlaceHolderApi
import hamidov.sardor.goodzone.retrofit.MainRepository
import java.lang.IllegalArgumentException

class HomeFragmentViewModelFactory constructor(private val repository: MainRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeFagmentViewModel::class.java)) {
            HomeFagmentViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
    }
}
}