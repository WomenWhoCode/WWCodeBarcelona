package com.womenwhocode.android.workshop.spacex.data.services

import com.womenwhocode.android.workshop.spacex.data.model.LaunchDataApi
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Rocio Ortega on 19/05/2018.
 */
interface LaunchApi {
    @GET("launches")
    fun getLaunches(): Call<List<LaunchDataApi>>
}