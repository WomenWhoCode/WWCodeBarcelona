package com.womenwhocode.android.workshop.spacex.di

import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Created by Rocio Ortega on 19/05/2018.
 */
fun myAppModules() = listOf(dataSourceModule, domainModule, myModule)

val myModule: Module = applicationContext {

}