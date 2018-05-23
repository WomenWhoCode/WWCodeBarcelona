package com.womenwhocode.android.workshop.spacex.presentation.detail

/**
 *  :3
 */

class LaunchDetailPresenter {

    var view: LaunchDetailView? = null

    fun loadLaunchDetail(missionName: String, launchYear: String, launchSuccess: Boolean, details: String, rocketName: String, siteName: String, image: String) {
        view?.displayLaunchDetail(missionName,launchYear,launchSuccess,details,rocketName,siteName,image)
    }

}