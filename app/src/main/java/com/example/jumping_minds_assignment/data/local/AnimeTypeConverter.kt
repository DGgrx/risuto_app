package com.example.jumping_minds_assignment.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.jumping_minds_assignment.domain.models.Aired
import com.example.jumping_minds_assignment.domain.models.Broadcast
import com.example.jumping_minds_assignment.domain.models.Genre
import com.example.jumping_minds_assignment.domain.models.Images
import com.example.jumping_minds_assignment.domain.models.ImagesX
import com.example.jumping_minds_assignment.domain.models.Trailer
import com.example.jumping_minds_assignment.domain.models.Webp

@ProvidedTypeConverter
class AnimeTypeConverter {

    @TypeConverter
    fun airedToString(source: Aired): String {
        return source.string ?: ""
    }

    @TypeConverter
    fun stringToAired(source: String): Aired {
        return Aired(string = source)
    }

    @TypeConverter
    fun broadcastToString(source: Broadcast): String {
        return source.timezone ?: ""
    }

    @TypeConverter
    fun stringToBroadcast(source: String): Broadcast {
        return Broadcast(timezone = source)
    }

    @TypeConverter
    fun genresToString(source: List<Genre>): String {
        return source.joinToString(",") { it.name ?: "" }
    }

    @TypeConverter
    fun stringToGenres(source: String): List<Genre> {
        return source.split(',').map { names -> Genre(name = names) }
    }

    @TypeConverter
    fun imagesToString(source: Images) :String{
        return source.webp?.large_image_url ?:""
    }

    @TypeConverter
    fun stringToImages(source: String) :Images{
        return Images(webp = Webp(large_image_url = source))
    }

    @TypeConverter
    fun trailerToString(source: Trailer) :String{
        return "${source.url},${source.embed_url},${source.images?.maximum_image_url},${source.youtube_id}"
    }

    @TypeConverter
    fun stringToTrailer(source: String) :Trailer {
        return source.split(',').let{ values->
            Trailer(
                url = values[0],
                embed_url = values[1],
                images = ImagesX(values[2]),
                youtube_id = values[3]
            )
        }
    }


}