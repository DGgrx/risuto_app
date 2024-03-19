package com.example.jumping_minds_assignment.di

import android.app.Application
import com.example.jumping_minds_assignment.data.manger.LocalUserMangerImpl
import com.example.jumping_minds_assignment.domain.manger.LocalUserManger
import com.example.jumping_minds_assignment.domain.usecases.AppEntryUseCases
import com.example.jumping_minds_assignment.domain.usecases.ReadAppEntry
import com.example.jumping_minds_assignment.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManger: LocalUserManger) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

}
