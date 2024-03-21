package com.example.jumping_minds_assignment.di

import android.app.Application
import androidx.room.Room
import com.example.jumping_minds_assignment.data.local.AnimeDao
import com.example.jumping_minds_assignment.data.local.AnimeDatabase
import com.example.jumping_minds_assignment.data.local.AnimeTypeConverter
import com.example.jumping_minds_assignment.data.manager.LocalUserMangerImpl
import com.example.jumping_minds_assignment.data.remote.AnimeApi
import com.example.jumping_minds_assignment.data.repository.AnimeRepositoryImpl
import com.example.jumping_minds_assignment.domain.manager.LocalUserManger
import com.example.jumping_minds_assignment.domain.repository.AnimeRepository
import com.example.jumping_minds_assignment.domain.usecases.anime.AnimeUseCases
import com.example.jumping_minds_assignment.domain.usecases.anime.DeleteAnime
import com.example.jumping_minds_assignment.domain.usecases.anime.GetFavAnimeByID
import com.example.jumping_minds_assignment.domain.usecases.anime.GetFavouriteAnime
import com.example.jumping_minds_assignment.domain.usecases.anime.GetTopAnime
import com.example.jumping_minds_assignment.domain.usecases.anime.InsertAnime
import com.example.jumping_minds_assignment.domain.usecases.anime.MarkAsFavAnime
import com.example.jumping_minds_assignment.domain.usecases.anime.SearchAnime
import com.example.jumping_minds_assignment.domain.usecases.app_entry.AppEntryUseCases
import com.example.jumping_minds_assignment.domain.usecases.app_entry.ReadAppEntry
import com.example.jumping_minds_assignment.domain.usecases.app_entry.SaveAppEntry
import com.example.jumping_minds_assignment.utils.Constants.ANIME_DATABASE_NAME
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
    fun providesAnimeRepository(animeApi: AnimeApi,animeDao: AnimeDao): AnimeRepository =
        AnimeRepositoryImpl(animeApi = animeApi, animeDao = animeDao)


    @Provides
    @Singleton
    fun providesAnimeUseCases(
        getTopAnime: GetTopAnime,
        searchAnime: SearchAnime,
        deleteAnime: DeleteAnime,
        getFavouriteAnime: GetFavouriteAnime,
        markAsFavAnime: MarkAsFavAnime,
        insertAnime: InsertAnime,
        getFavAnimeByID: GetFavAnimeByID
    ): AnimeUseCases {
        return AnimeUseCases(
            getTopAnime = getTopAnime,
            searchAnime = searchAnime,
            deleteAnime = deleteAnime,
            markAsFavAnime = markAsFavAnime,
            getFavouriteAnime = getFavouriteAnime,
            insertAnime = insertAnime,
            getFavAnimeByID = getFavAnimeByID
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

    @Provides
    @Singleton
    fun providesGetFavouriteAnime(animeDao: AnimeDao): GetFavouriteAnime {
        return GetFavouriteAnime(animeDao)
    }

    @Provides
    @Singleton
    fun providesMarkAsFavAnime(animeDao: AnimeDao): MarkAsFavAnime {
        return MarkAsFavAnime(animeDao)
    }

    @Provides
    @Singleton
    fun providesDeleteAnime(animeDao: AnimeDao): DeleteAnime {
        return DeleteAnime(animeDao)
    }

    @Provides
    @Singleton
    fun providesInsertAnime(animeDao: AnimeDao): InsertAnime {
        return InsertAnime(animeDao)
    }

    @Provides
    @Singleton
    fun providesGetFavAnimeByID(animeDao: AnimeDao): GetFavAnimeByID {
        return GetFavAnimeByID(animeDao)
    }



    @Provides
    @Singleton
    fun providesAnimeDatabase(
        application: Application
    ): AnimeDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = AnimeDatabase::class.java,
            name = ANIME_DATABASE_NAME,
        ).addTypeConverter(AnimeTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun providesAnimeDao(
        animeDatabase: AnimeDatabase
    ): AnimeDao = animeDatabase.animeDao

}
