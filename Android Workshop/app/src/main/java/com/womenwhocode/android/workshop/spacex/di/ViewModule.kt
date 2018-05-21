package com.womenwhocode.android.workshop.spacex.di

import com.womenwhocode.android.workshop.spacex.presentation.detail.LaunchDetailPresenter
import org.koin.dsl.module.applicationContext

val viewModule = applicationContext {
    //bean { LaunchesListPresenter(get()) }
    bean { LaunchDetailPresenter() }
}
