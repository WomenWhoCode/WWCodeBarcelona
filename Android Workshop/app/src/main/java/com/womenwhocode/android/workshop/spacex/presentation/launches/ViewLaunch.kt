package com.womenwhocode.android.workshop.spacex.presentation.launches


//Object that represents one item of the list or one Launch containing
// all the fields we will display in the list and in the detail views.
data class ViewLaunch(
        val missionName: String,
        val launchYear: String,
        val launchSuccess: Boolean,
        val details: String?,
        val rocketName: String,
        val siteName: String,
        val image: String,
        val smallImage: String)
