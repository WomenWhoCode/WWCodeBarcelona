package com.womenwhocode.android.workshop.spacex.presentation.detail


/**
 *  :3
 */

interface LaunchDetailView {

    fun displayLaunchDetail(missionName: String, launchYear: String, launchSuccess: Boolean, details: String, rocketName: String, siteName: String, image: String)
}