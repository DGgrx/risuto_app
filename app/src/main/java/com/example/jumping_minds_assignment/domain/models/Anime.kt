package com.example.jumping_minds_assignment.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey


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
)

data class Aired(
    val string: String?,
)

data class Genre(
    val name: String?,
)

data class Broadcast(
    val timezone: String?
)

data class Webp(
    val large_image_url: String?,
)

data class Images(
    val webp: Webp?
)

data class Trailer(
    val embed_url: String?,
    val youtube_id: String?,
    val url: String?,
    val images: ImagesX,
)

data class ImagesX(
    val maximum_image_url:String?
)
