package com.womenwhocode.android.workshop.spacex.presentation.launches

import com.womenwhocode.android.workshop.spacex.domain.model.Launch


interface LaunchesListView {

    fun displayLaunches(launches: List<Launch>?)

    fun showLoading()
}
