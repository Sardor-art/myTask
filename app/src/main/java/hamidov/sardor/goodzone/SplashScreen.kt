package hamidov.sardor.goodzone

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import hamidov.sardor.goodzone.common.Constants
import hamidov.sardor.goodzone.main.MainActivity


class SplashScreen : AppCompatActivity() {
    private  val TAG = "SplashScreen"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        Constants.height = displayMetrics.heightPixels
        Constants.width = displayMetrics.widthPixels
        Log.d(TAG, "onCreate: width ${Constants.width}")
        Log.d(TAG, "onCreate: height ${Constants.height}")

        setContentView(R.layout.splash_screen)
        Handler().postDelayed(Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)

    }
}