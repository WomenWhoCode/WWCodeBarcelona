package com.womenwhocode.android.workshop.spacex.presentation.launches

import android.util.Log
import com.womenwhocode.android.workshop.spacex.domain.model.Launch
import com.womenwhocode.android.workshop.spacex.domain.usecases.GetLaunchesUseCase


class LaunchesListPresenter(private val useCase: GetLaunchesUseCase) {

    var view: LaunchesListActivity? = null

    fun loadLaunches() {
        view?.showLoading()
        useCase.execute(onError = { doOnGetLaunchesError(it) },
                onSuccess = { doOnGetLaunchesSuccess(it) })
    }

    private fun doOnGetLaunchesError(throwable: Throwable?) {
        //TODO: show error to user
        Log.e("LaunchesListPresenter", "error loading launches", throwable)
        view?.hideLoading()
        view?.showErrorGettingLaunches()
    }

    private fun doOnGetLaunchesSuccess(launches: List<Launch>?) {
        view?.hideLoading()
        view?.displayLaunches(toViewLaunches(launches))
    }

    private fun toViewLaunches(launches: List<Launch>?): List<ViewLaunch> {
        return launches?.map { toViewLaunch(it) } ?: ArrayList()
    }

    private fun toViewLaunch(launch: Launch): ViewLaunch {
        return ViewLaunch(
                launch.missionName,
                launch.launchYear,
                launch.launchSuccess,
                launch.details,
                launch.rocket.name,
                launch.site.name,
                launch.image,
                launch.smallImage)
    }
}
