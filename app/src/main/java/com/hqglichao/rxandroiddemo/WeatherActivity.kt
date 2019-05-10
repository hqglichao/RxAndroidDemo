package com.hqglichao.rxandroiddemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.hqglichao.rxandroiddemo.retrofit.IApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_tip_search.*
import java.lang.StringBuilder

/**
 *
 * @author beyond
 * @date 19-5-8
 *
 */
class WeatherActivity : AppCompatActivity() {
    lateinit var disposable: Disposable

    private val weatherService: IApiService by lazy {
        IApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_search)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnSearch -> {
                requestSearchCount()
            }
        }
    }

    private fun requestSearchCount() {
        //请求上海的天气：101020100
        disposable = weatherService.getWeatherInfo("101020100")
            .subscribeOn(Schedulers.io())
            .map {
                it.weatherinfo
            }.observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append(it.city)
                        .append("\r\n")
                        .append(getString(R.string.temperature))
                        .append(it.temp)
                        .append("\r\n")
                        .append(getString(R.string.wind))
                        .append(it.WD)
                        .append(" ")
                        .append(it.WS)
                    tvCount.text = stringBuilder.toString()
                }) {
                error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
            }
    }
}