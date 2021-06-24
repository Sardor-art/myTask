package hamidov.sardor.goodzone.main.home.allItem

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import hamidov.sardor.goodzone.R
import hamidov.sardor.goodzone.common.Constants
import hamidov.sardor.goodzone.databinding.ItemFragmentBinding
import hamidov.sardor.goodzone.main.home.HomeFagment
import hamidov.sardor.goodzone.main.home.adapters.FamousAdapter
import hamidov.sardor.goodzone.main.home.adapters.NewsAdapter
import hamidov.sardor.goodzone.main.home.adapters.PromotionsAdapter
import hamidov.sardor.goodzone.main.home.adapters.RecommendedAdapter
import hamidov.sardor.goodzone.models.Promo
import hamidov.sardor.goodzone.models.PromoX

class ItemFragment : Fragment() {

    companion object {
        fun newInstance() = ItemFragment()
    }

    private val TAG = "ItemFragment"
    private lateinit var viewModel: ItemViewModel
    private lateinit var binding: ItemFragmentBinding
    private val adapter = IteamAdapter()
    private val adapter1 = ProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        binding.ibBack.setOnClickListener {
            fragmentManager!!.beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, HomeFagment()).commit()
        }
        setup()
    }

    private fun setup() {
        val layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvItem.layoutManager = layoutManager
        binding.rvItem.adapter = adapter
        adapter.setDiscountList(Constants.promotions!!)
        Log.d(TAG, "setup: ${arguments!!.get("title")}")
        when (arguments!!.get("num").toString()) {
            "promotion" -> {
                binding.itemTitle.text = arguments!!.get("title").toString()
                val layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvItem.layoutManager = layoutManager
                binding.rvItem.adapter = adapter
                adapter.setDiscountList(Constants.promotions!!)
                Log.d(TAG, "setup: ${arguments!!.get("title")}")
            }
            "famous" -> {
                binding.itemTitle.text = arguments!!.get("title").toString()
                val layoutManager =
                    GridLayoutManager(context, 2)
                binding.rvItem.layoutManager = layoutManager
                binding.rvItem.adapter = adapter1
                Log.d(TAG, "setup: ${arguments!!.get("title")}")
                adapter1.setProductList(Constants.famous!!)
            }
            "news" -> {
                binding.itemTitle.text = arguments!!.get("title").toString()
                val layoutManager =
                    GridLayoutManager(context, 2)
                binding.rvItem.layoutManager = layoutManager
                binding.rvItem.adapter = adapter1
                Log.d(TAG, "setup: ${arguments!!.get("title")}")
                adapter1.setProductList(Constants.newsList!!)
            }
            "recom" -> {
                binding.itemTitle.text = arguments!!.get("title").toString()
                val layoutManager =
                    GridLayoutManager(context, 2)
                binding.rvItem.layoutManager = layoutManager
                binding.rvItem.adapter = adapter1
                Log.d(TAG, "setup: ${arguments!!.get("title")}")
                adapter1.setProductList(Constants.recommended!!)
            }
        }


    }

}