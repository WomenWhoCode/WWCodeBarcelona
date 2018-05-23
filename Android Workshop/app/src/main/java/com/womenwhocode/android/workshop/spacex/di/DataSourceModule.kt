package com.womenwhocode.android.workshop.spacex.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.womenwhocode.android.workshop.spacex.data.datasources.LaunchCloudDataSource
import com.womenwhocode.android.workshop.spacex.data.services.LaunchApi
import okhttp3.OkHttpClient
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Rocio Ortega on 19/05/2018.
 */
const val API_BASE_URL = "https://api.spacexdata.com/v2/"

val dataSourceModule = applicationContext {
    bean { provideLaunchCloudDataSource(get()) }
    bean { provideLaunchApi(get()) }
    bean { provideRetrofit(get(), get()) }
    bean { provideGson() }
    bean { provideOkHttpClient() }
}

fun provideLaunchCloudDataSource(launchApi: LaunchApi) = LaunchCloudDataSource(launchApi)

fun provideLaunchApi(retrofit: Retrofit): LaunchApi = retrofit.create(LaunchApi::class.java)

fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

fun provideGson(): Gson = GsonBuilder()
        .create()

fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .build()