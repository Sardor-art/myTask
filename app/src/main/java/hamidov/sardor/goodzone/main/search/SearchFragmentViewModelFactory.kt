package hamidov.sardor.goodzone.main.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hamidov.sardor.goodzone.main.home.HomeFagmentViewModel
import hamidov.sardor.goodzone.retrofit.MainRepository
import java.lang.IllegalArgumentException

class SearchFragmentViewModelFactory constructor(private val repository: MainRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            SearchViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}