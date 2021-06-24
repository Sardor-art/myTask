package hamidov.sardor.goodzone.retrofit

import hamidov.sardor.goodzone.common.Constants
import hamidov.sardor.goodzone.models.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.io.IOException

interface JsonPlaceHolderApi {
    @GET("v1/featured-list")
    fun getFeaturedList(): Call<FeaturedList>

    @GET("v1/brand")
    fun getBrands():Call<Brands>

    @GET("v1/promo")
    fun getDiscounts(
        @Query("active") active:Boolean
    ):Call<Promo>

    @GET("v1/category")
    fun getCategory():Call<Categories>

    companion object {
        var jsonPlaceHolderApi: JsonPlaceHolderApi? = null

        fun getInstance(): JsonPlaceHolderApi {
            if (jsonPlaceHolderApi == null) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

                val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                    .addInterceptor(object : Interceptor {
                        @Throws(IOException::class)
                        override fun intercept(chain: Interceptor.Chain): Response {
                            val originalRequest: Request = chain.request()
                            val newRequest = originalRequest.newBuilder()
                                .header("content-type", "application/json")
                                .build()
                            return chain.proceed(newRequest)
                        }
                    })
                    .addInterceptor(loggingInterceptor)
                    .build()


                val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()


                jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
            }
            return jsonPlaceHolderApi!!
        }
    }
}
