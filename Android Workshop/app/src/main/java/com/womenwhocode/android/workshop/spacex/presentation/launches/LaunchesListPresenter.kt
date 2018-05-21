package com.womenwhocode.android.workshop.spacex.presentation.launches

import android.util.Log
import com.womenwhocode.android.workshop.spacex.domain.model.Launch
import com.womenwhocode.android.workshop.spacex.domain.usecases.GetLaunchesUseCase


class LaunchesListPresenter(val useCase: GetLaunchesUseCase) {

    var view: LaunchesListActivity? = null

    fun loadLaunches() {
        view?.showLoading()
        useCase.execute(onError = {doOnFailure(it)}, onSuccess = {doOnSuccess(it)});
    }

    private fun doOnFailure(throwable: Throwable?) {
        //TODO: show error to user
        Log.e("LaunchesListPresenter", "error loading launches", throwable)
    }

    private fun doOnSuccess(launches: List<Launch>?) {
        Log.i("LaunchesListPresenter", launches?.toString())
        view?.displayLaunches(launches);
    }
}
