package it.nhuviet.sync

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity_Sync : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sync)
    }
    private fun setBackgrounds() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            forgot.setBackgroundDrawable(resources.getDrawable(R.drawable.tv_ripple))

        }
    }

}

