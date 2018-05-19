package com.womenwhocode.spacex.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Rocio Ortega on 19/05/2018.
 */
data class LaunchDataApi(
        @SerializedName("flight_number") val flightNumber: Int,
        @SerializedName("mission_name") val missionName: String,
        @SerializedName("launch_year") val launchYear: String,
        @SerializedName("launch_date_unix") val launchDateUnix: Long,
        @SerializedName("launch_success") val launchSuccess: Boolean,
        val details: String,
        val rocket: RocketDataApi,
        val telemetry: TelemetryDataApi,
        val reuse: ReuseDataApi,
        @SerializedName("launch_site") val site: SiteDataApi,
        val links: LinksDataApi)

data class LinksDataApi(
        @SerializedName("mission_patch") val missionPath: String,
        @SerializedName("mission_patch_small") val missionPathSmall: String,
        @SerializedName("article_link") val articleLink: String,
        val wikipedia: String,
        @SerializedName("video_link") val videoLink: String)

data class SiteDataApi(
        @SerializedName("site_id") val id: String,
        @SerializedName("site_name") val name: String,
        @SerializedName("site_name_long") val nameLong: String)

data class ReuseDataApi(val core: Boolean,
                 @SerializedName("side_core1") val sideCore1: Boolean,
                 @SerializedName("side_core2") val sideCore2: Boolean,
                 val fairings: Boolean,
                 val capsule: Boolean)

data class TelemetryDataApi(@SerializedName("flight_club") val flightClub: String)

data class RocketDataApi(
        @SerializedName("rocket_id") val id: String,
        @SerializedName("rocket_name") val name: String,
        @SerializedName("rocket_type") val type: String,
        @SerializedName("first_stage") val firstStage: FirstStageDataApi,
        @SerializedName("second_stage") val secondStage: SecondStageDataApi)

data class FirstStageDataApi(val cores: List<CoreDataApi>)

data class CoreDataApi(
        @SerializedName("core_serial") val serial: String,
        val flight: Int,
        val block: String,
        val reused: Boolean,
        @SerializedName("land_success") val landSuccess: Boolean,
        @SerializedName("landing_type") val landingType: String,
        @SerializedName("landing_vehicle") val landingVehicle: String)

data class SecondStageDataApi(val payloads: List<PayloadDataApi>)

data class PayloadDataApi(
        @SerializedName("payload_id") val id: String,
        val reused: Boolean,
        val customers: List<String>,
        @SerializedName("payload_type") val type: String,
        @SerializedName("payload_mass_kg") val massKg: Double,
        @SerializedName("payload_mass_lbs") val massLbs: Double,
        val orbit: String)