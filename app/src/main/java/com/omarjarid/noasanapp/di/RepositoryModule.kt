package com.omarjarid.noasanapp.di

import com.omarjarid.data.repositories.ReasonRepositoryImpl
import com.omarjarid.domain.repositories.ReasonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideReasonRepository(repo: ReasonRepositoryImpl): ReasonRepository
}