package com.example.enigma_music.room.album

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
class Album(
    @PrimaryKey(autoGenerate = true) val albumId:Int = 0,
    val albumTitle: String,
    val artist: String,
    val imgUrl:String
)

@Entity
class Song(
    @PrimaryKey(autoGenerate = true) val songId:Int = 0,
    val songAlbumId: Int,
    val songName: String,
    val songDuration: String
)

data class AlbumWithSong(
    @Embedded val Album : Album,
    @Relation(
        parentColumn ="albumId",
        entityColumn = "songAlbumId"
    )
    val song : Song
)