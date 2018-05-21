package com.womenwhocode.android.workshop.spacex.presentation.detail

import com.womenwhocode.android.workshop.spacex.domain.model.Launch

/**
 *  :3
 */

class LaunchDetailPresenter {

    var view: LaunchDetailActivity? = null

    fun loadLaunchDetail(launch: Launch) {
        view?.displayLaunchDetail(launch)
    }

}