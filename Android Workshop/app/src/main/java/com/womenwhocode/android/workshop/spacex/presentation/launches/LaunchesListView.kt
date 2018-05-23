package com.womenwhocode.android.workshop.spacex.presentation.launches

interface LaunchesListView {

    fun displayLaunches(launches: List<ViewLaunch>?)

    fun showLoading()

    fun hideLoading()

    fun showErrorGettingLaunches()
}
