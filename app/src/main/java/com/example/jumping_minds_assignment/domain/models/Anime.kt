package com.example.jumping_minds_assignment.domain.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "anime")
data class Anime(
    val aired: Aired?,
    val background: String?,
    val broadcast: Broadcast?,
    val duration: String?,
    val episodes: Int?,
    val favorites: Int?,
    val genres: List<Genre>?,
    val images: Images?,
    @PrimaryKey val mal_id: Int?,
    val members: Int?,
    val popularity: Int?,
    val rank: Int?,
    val rating: String?,
    val score: Double?,
    val season: String?,
    val source: String?,
    val status: String?,
    val synopsis: String?,
    val title: String?,
    val title_english: String?,
    val title_japanese: String?,
    val trailer: Trailer?,
    val type: String?,
    val url: String?,
    val year: Int?,
    val isFavourite :Boolean = false
):Parcelable

@Parcelize
data class Aired(
    val string: String?,
):Parcelable

@Parcelize
data class Genre(
    val name: String?,
):Parcelable

@Parcelize
data class Broadcast(
    val timezone: String?
):Parcelable

@Parcelize
data class Webp(
    val large_image_url: String?,
):Parcelable

@Parcelize
data class Images(
    val webp: Webp?
):Parcelable

@Parcelize
data class Trailer(
    val embed_url: String?,
    val youtube_id: String?,
    val url: String?,
    val images: ImagesX?,
):Parcelable

@Parcelize
data class ImagesX(
    val maximum_image_url:String?
):Parcelable
