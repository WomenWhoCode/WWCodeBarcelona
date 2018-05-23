package com.womenwhocode.android.workshop.spacex.di

import com.womenwhocode.android.workshop.spacex.data.datasources.LaunchCloudDataSource
import com.womenwhocode.android.workshop.spacex.domain.repositories.LaunchRepository
import com.womenwhocode.android.workshop.spacex.domain.usecases.GetLaunchesUseCase
import org.koin.dsl.module.applicationContext

/**
 * Created by Rocio Ortega on 20/05/2018.
 */
val domainModule = applicationContext {
    bean { provideGetLaunchesUseCase(get()) }
    bean { provideLaunchRepository(get()) }
}

fun provideLaunchRepository(launchCloudDataSource: LaunchCloudDataSource) = LaunchRepository(launchCloudDataSource)

fun provideGetLaunchesUseCase(launchRepository: LaunchRepository) = GetLaunchesUseCase(launchRepository)