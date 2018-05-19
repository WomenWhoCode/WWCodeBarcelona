package com.womenwhocode.spacex.di

import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Created by Rocio Ortega on 19/05/2018.
 */
fun myAppModules() = listOf(myModule, dataSourceModule)

val myModule: Module = applicationContext {

}