package com.womenwhocode.android.workshop.spacex.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Rocio Ortega on 19/05/2018.
 */
@Parcelize
data class Launch(
        val flightNumber: Int,
        val missionName: String,
        val launchYear: String,
        val launchDateUnix: Long,
        val launchSuccess: Boolean,
        val details: String?,
        val rocket: Rocket,
        val site: Site,
        val image: String,
        val smallImage: String) :Parcelable
@Parcelize
data class Rocket(
        val id: String,
        val name: String,
        val type: String):Parcelable
@Parcelize
data class Site(
        val id: String,
        val name: String,
        val nameLong: String):Parcelable
