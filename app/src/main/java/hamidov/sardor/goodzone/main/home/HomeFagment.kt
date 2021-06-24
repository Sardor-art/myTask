package hamidov.sardor.goodzone.main.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import hamidov.sardor.goodzone.R
import hamidov.sardor.goodzone.common.Constants
import hamidov.sardor.goodzone.databinding.HomeFagmentBinding
import hamidov.sardor.goodzone.main.home.adapters.*
import hamidov.sardor.goodzone.main.home.allItem.ItemFragment
import hamidov.sardor.goodzone.models.Promo
import hamidov.sardor.goodzone.models.PromoX
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

    private var sliderHandler: Handler = Handler()
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
        binding.homeBanner.clipToPadding = false
        binding.homeBanner.clipChildren = false
        binding.homeBanner.offscreenPageLimit = 3
        binding.homeBanner.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER)

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.setScaleY(0.85f + r * 0.15f)
        }
        binding.homeBanner.setPageTransformer(compositePageTransformer)

        binding.homeBanner.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun setDiscounts() {


        binding.rvPromotion.setHasFixedSize(true)
        binding.rvPromotion.adapter = promotionsAdapter
        viewModel.discounts.observe(viewLifecycleOwner, Observer { promo: Promo ->
            promotionsAdapter.setDiscountList(promo.promos)
            binding.homeBanner.adapter =
                BannerAdapter(promo.promos as ArrayList<PromoX>, binding.homeBanner)
            Constants.promotions = promo.promos
            binding.promotionsAll.setOnClickListener {
                val bundle = bundleOf(
                    "data" to promo.promos,
                    "title" to binding.promotionsTitle.text,
                    "num" to "promotion"
                )
                switchToFragment(ItemFragment(), bundle)
            }


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
                        Constants.famous = it.featured_lists[i].products
                        binding.famousAll.setOnClickListener {
                            val bundle = bundleOf(
                                "title" to binding.famousTitle.text,
                                "num" to "famous"
                            )
                            switchToFragment(ItemFragment(), bundle)
                        }

                    }
                    1 -> {
                        binding.newsTitle.text = it.featured_lists[i].title
                        newsAdapter.setProductList(it.featured_lists[i].products)
                        Constants.newsList = it.featured_lists[i].products
                        binding.newsAll.setOnClickListener {
                            val bundle = bundleOf(
                                "title" to binding.newsTitle.text,
                                "num" to "news"
                            )
                            switchToFragment(ItemFragment(), bundle)
                        }
                    }
                    2 -> {
                        binding.recommendedTitle.text = it.featured_lists[i].title
                        Constants.recommended = it.featured_lists[i].products
                        binding.recommendedAll.setOnClickListener {
                            val bundle = bundleOf(
                                "title" to binding.recommendedTitle.text,
                                "num" to "recom"
                            )
                            switchToFragment(ItemFragment(), bundle)
                        }
                        recommendedAdapter.setProductList(it.featured_lists[i].products)
                    }
                }

            }
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {

        })
        viewModel.getFeaturesList()
    }

    private var sliderRunnable: Runnable = Runnable {
        binding.homeBanner.setCurrentItem(binding.homeBanner.currentItem + 1)
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 3000)
    }

    private fun switchToFragment(fragment: Fragment, bundle: Bundle) {
        fragmentManager!!.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, fragment::class.java, bundle).commit()
    }
}

