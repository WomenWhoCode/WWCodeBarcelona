package com.womenwhocode.android.workshop.spacex.presentation.launches

//Interface used to comunicate the presenter with the view
interface LaunchesListView {

    fun displayLaunches(launches: List<ViewLaunch>?)

    fun showLoading()

    fun hideLoading()

    fun showErrorGettingLaunches()
}
