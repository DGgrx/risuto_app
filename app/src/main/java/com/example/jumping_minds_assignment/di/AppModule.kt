package com.example.jumping_minds_assignment.di

import android.app.Application
import com.example.jumping_minds_assignment.data.manger.LocalUserMangerImpl
import com.example.jumping_minds_assignment.data.remote.AnimeApi
import com.example.jumping_minds_assignment.data.repository.AnimeRepositoryImpl
import com.example.jumping_minds_assignment.domain.manger.LocalUserManger
import com.example.jumping_minds_assignment.domain.repository.AnimeRepository
import com.example.jumping_minds_assignment.domain.usecases.anime.AnimeUseCases
import com.example.jumping_minds_assignment.domain.usecases.anime.GetTopAnime
import com.example.jumping_minds_assignment.domain.usecases.anime.SearchAnime
import com.example.jumping_minds_assignment.domain.usecases.app_entry.AppEntryUseCases
import com.example.jumping_minds_assignment.domain.usecases.app_entry.ReadAppEntry
import com.example.jumping_minds_assignment.domain.usecases.app_entry.SaveAppEntry
import com.example.jumping_minds_assignment.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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


    @Provides
    @Singleton
    fun providesAnimeApi(): AnimeApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeApi::class.java)
    }

    @Provides
    @Singleton
    fun providesAnimeRepository(animeApi: AnimeApi): AnimeRepository =
        AnimeRepositoryImpl(animeApi = animeApi)

//    @Provides
//    @Singleton
//    fun providesAnimeUseCases(animeRepository: AnimeRepository): AnimeUseCases {
//        return AnimeUseCases(
//            getTopAnime = GetTopAnime(animeRepository = animeRepository),
//            searchAnime = SearchAnime(animeRepository = animeRepository)
//        )
//    }




    @Provides
    @Singleton
    fun providesAnimeUseCases(getTopAnime: GetTopAnime,searchAnime:SearchAnime ): AnimeUseCases {
        return AnimeUseCases(
            getTopAnime = getTopAnime,
            searchAnime = searchAnime
        )
    }

    @Provides
    @Singleton
    fun providesGetTopAnime(animeRepository: AnimeRepository): GetTopAnime {
        return GetTopAnime(animeRepository)
    }

    @Provides
    @Singleton
    fun providesSearchAnime(animeRepository: AnimeRepository): SearchAnime {
        return SearchAnime(animeRepository)
    }
}
