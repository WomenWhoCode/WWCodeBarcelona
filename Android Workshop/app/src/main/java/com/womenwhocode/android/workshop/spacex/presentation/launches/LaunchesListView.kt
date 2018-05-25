package com.womenwhocode.android.workshop.spacex.presentation.launches

//Interface (contract) that the view must implement. The presenter uses these methods to tell the view what to do.
interface LaunchesListView {

    fun displayLaunches(launches: List<ViewLaunch>?)

    fun showLoading()

    fun hideLoading()

    fun showErrorGettingLaunches()
}
