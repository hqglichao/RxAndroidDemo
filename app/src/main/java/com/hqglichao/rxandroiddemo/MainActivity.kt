package com.hqglichao.rxandroiddemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClick(view : View) {
        when(view.id) {
            R.id.btnWiki -> {
                val intent = Intent(this, WeatherActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
