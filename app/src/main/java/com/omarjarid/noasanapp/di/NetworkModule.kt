package com.omarjarid.noasanapp.di

import com.omarjarid.data.datasources.NetworkDatasource
import com.omarjarid.data.network.NetworkDatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkModule {
    @Binds
    @Singleton
    abstract fun provideExampleDatasource(ds: NetworkDatasourceImpl): NetworkDatasource
}