package hamidov.sardor.goodzone.main.search

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import hamidov.sardor.goodzone.R
import hamidov.sardor.goodzone.databinding.SearchFragmentBinding
import hamidov.sardor.goodzone.main.home.HomeFagmentViewModel
import hamidov.sardor.goodzone.main.home.HomeFragmentViewModelFactory
import hamidov.sardor.goodzone.main.search.adapter.SearchAdapter
import hamidov.sardor.goodzone.retrofit.JsonPlaceHolderApi
import hamidov.sardor.goodzone.retrofit.MainRepository

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private val jsonPlaceHolderApi = JsonPlaceHolderApi.getInstance()
    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: SearchFragmentBinding
    private val adapter = SearchAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            SearchFragmentViewModelFactory(MainRepository(jsonPlaceHolderApi))
        ).get(SearchViewModel::class.java)
        setup()
    }

    private fun setup() {
        binding.rvSearch.setHasFixedSize(true)
        binding.rvSearch.adapter = adapter
        viewModel.category.observe(viewLifecycleOwner, Observer {
            adapter.setProductList(it.categories)
        })
        viewModel.getCategoryList()
    }

}