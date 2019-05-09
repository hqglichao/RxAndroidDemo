package com.hqglichao.rxandroiddemo.model

/**
 *
 * @author beyond
 * @date 19-5-8
 *
 */
object WeatherModel {
    data class Result(val weatherinfo: WeatherInfo)
    data class WeatherInfo(val city: String,
                           val temp: String,
                           val WD: String,
                           val WS: String)
}