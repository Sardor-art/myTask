package hamidov.sardor.goodzone.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import hamidov.sardor.goodzone.R
import hamidov.sardor.goodzone.common.Constants
import hamidov.sardor.goodzone.databinding.ActivityMainBinding
import hamidov.sardor.goodzone.main.cart.CartFragment
import hamidov.sardor.goodzone.main.fav.FavoriteFragment
import hamidov.sardor.goodzone.main.home.HomeFagment
import hamidov.sardor.goodzone.main.profile.ProfileFragment
import hamidov.sardor.goodzone.main.search.SearchFragment
import hamidov.sardor.goodzone.models.FeaturedList
import hamidov.sardor.goodzone.retrofit.JsonPlaceHolderApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (!binding.bottomMenu.isSelected) {
            switchToFragment(HomeFagment())
        }
        bottomNavigationListener()

    }
    private fun bottomNavigationListener() {
        binding.bottomMenu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    Log.d(TAG, "onNavigationItemSelected: home")
                    switchToFragment(HomeFagment())
                }
                R.id.search -> {
                    Log.d(TAG, "onNavigationItemSelected: search")
                    switchToFragment(SearchFragment())
                }
                R.id.category -> {
                    Log.d(TAG, "onNavigationItemSelected: cart")
                    switchToFragment(CartFragment())
                }
                R.id.favorite -> {
                    Log.d(TAG, "onNavigationItemSelected: favorite")
                    switchToFragment(FavoriteFragment())
                }
                R.id.profile -> {
                    Log.d(TAG, "onNavigationItemSelected: profile")
                    switchToFragment(ProfileFragment())
                }
            }
            Log.d(TAG, "onNavigationItemSelected: ${item.itemId}")
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun switchToFragment(fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        manager.beginTransaction().replace(R.id.nav_host_fragment_content_main, fragment).commit()
    }

}