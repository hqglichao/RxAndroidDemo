package com.hqglichao.rxandroiddemo.retrofit

import com.hqglichao.rxandroiddemo.Constants
import com.hqglichao.rxandroiddemo.model.WeatherModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * @author beyond
 * @date 19-5-8
 *
 */
interface IApiService {
    @GET("{cityID}.html")
    fun getWeatherInfo(@Path("cityID") cityID: String) : Observable<WeatherModel.Result>
    companion object {
        fun create() : IApiService {
            return Retrofit.Builder()
                .baseUrl(Constants.WEATHER_INFO_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IApiService::class.java)
        }
    }
}