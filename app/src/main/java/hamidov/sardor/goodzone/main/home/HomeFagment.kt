package hamidov.sardor.goodzone.main.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import hamidov.sardor.goodzone.databinding.HomeFagmentBinding
import hamidov.sardor.goodzone.main.home.adapters.*
import hamidov.sardor.goodzone.retrofit.JsonPlaceHolderApi
import hamidov.sardor.goodzone.retrofit.MainRepository


class HomeFagment : Fragment() {

    companion object {
        fun newInstance() = HomeFagment()
    }

    private val TAG = "HomeFagment"
    private lateinit var viewModel: HomeFagmentViewModel
    private lateinit var binding: HomeFagmentBinding
    private val jsonPlaceHolderApi = JsonPlaceHolderApi.getInstance()

    private val promotionsAdapter = PromotionsAdapter()
    private val famousAdapter = FamousAdapter()
    private val newsAdapter = NewsAdapter()
    private val recommendedAdapter = RecommendedAdapter()
    private val brandAdapter = BrandAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFagmentBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            HomeFragmentViewModelFactory(MainRepository(jsonPlaceHolderApi))
        ).get(HomeFagmentViewModel::class.java)

        setBanners()
        setDiscounts()
        setProducts()
        setBrands()
    }

    private fun setBanners() {
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun setDiscounts() {
        binding.rvPromotion.setHasFixedSize(true)
        binding.homeBanner.setPageTransformer(ZoomOutPageTransformer())
        binding.rvPromotion.adapter = promotionsAdapter
        viewModel.discounts.observe(viewLifecycleOwner, Observer {
            promotionsAdapter.setDiscountList(it.promos)
            binding.homeBanner.adapter = MySliderAdapter(context!!, it.promos, binding.homeBanner)

        })
        viewModel.getDiscounts()
    }

    private fun setBrands() {
        binding.rvBrand.setHasFixedSize(true)
        binding.rvBrand.adapter = brandAdapter
        viewModel.brands.observe(viewLifecycleOwner, Observer {
            brandAdapter.setBrandList(it.brands)
        })
        viewModel.getBrands()
    }



    private fun setProducts() {
        binding.rvFamous.setHasFixedSize(true)
        binding.rvFamous.adapter = famousAdapter
        binding.rvNews.adapter = newsAdapter
        binding.rvNews.setHasFixedSize(true)
        binding.rvRecommended.adapter = recommendedAdapter
        binding.rvRecommended.setHasFixedSize(true)
        binding.rvBrand.adapter = famousAdapter
        binding.rvBrand.setHasFixedSize(true)
        viewModel.featuredList.observe(viewLifecycleOwner, Observer {
            for (i in 0 until it.count.toInt()) {
                Log.d(TAG, "onActivityCreated: $it")
                when (i) {
                    0 -> {
                        binding.famousTitle.text = it.featured_lists[i].title
                        famousAdapter.setProductList(it.featured_lists[i].products)
                    }
                    1 -> {
                        binding.newsTitle.text = it.featured_lists[i].title
                        newsAdapter.setProductList(it.featured_lists[i].products)
                    }
                    2 -> {
                        binding.recommendedTitle.text = it.featured_lists[i].title
                        recommendedAdapter.setProductList(it.featured_lists[i].products)
                    }
                }

            }
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {

        })
        viewModel.getFeaturesList()
    }

}
