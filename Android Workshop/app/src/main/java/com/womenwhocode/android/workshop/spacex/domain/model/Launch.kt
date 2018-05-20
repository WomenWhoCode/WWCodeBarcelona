package com.womenwhocode.android.workshop.spacex.domain.model

/**
 * Created by Rocio Ortega on 19/05/2018.
 */
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
        val smallImage: String
) {
    override fun toString(): String {
        return "Launch(flightNumber=$flightNumber, missionName='$missionName', launchYear='$launchYear', launchDateUnix=$launchDateUnix, launchSuccess=$launchSuccess, details='$details', rocket=$rocket, site=$site, image='$image', smallImage='$smallImage')"
    }
}

data class Rocket(
        val id: String,
        val name: String,
        val type: String) {
    override fun toString(): String {
        return "Rocket(id='$id', name='$name', type='$type')"
    }
}

data class Site(
        val id: String,
        val name: String,
        val nameLong: String) {
    override fun toString(): String {
        return "Site(id='$id', name='$name', nameLong='$nameLong')"
    }
}
