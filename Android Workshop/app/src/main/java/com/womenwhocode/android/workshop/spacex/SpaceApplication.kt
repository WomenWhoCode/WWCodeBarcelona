package com.womenwhocode.android.workshop.spacex

import android.app.Application
import com.womenwhocode.android.workshop.spacex.di.myAppModules
import org.koin.android.ext.android.startKoin

/**
 * Created by Rocio Ortega on 19/05/2018.
 */
class SpaceApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //Init the Dependence Injection with Koin!! Check their web if you are curious is dead easy DI
        startKoin(this, myAppModules())
    }
}