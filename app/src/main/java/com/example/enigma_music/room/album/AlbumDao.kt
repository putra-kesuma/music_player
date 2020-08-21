package com.example.enigma_music.room.album

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface AlbumDao {
    @Transaction
    @Query("Select * From Album")
    fun getAlbumWithSong(): LiveData<List<AlbumWithSong>>

    @Query("Select * From Album")
    fun getAllAlbum(): LiveData<List<Album>>

    @Query("SELECT * FROM Album WHERE albumId =:id ")
    fun getAlbumWithId(id:Int): LiveData<Album>

    @Insert
    fun createNewAlbum(album: Album)

    @Query("select * from Song where songAlbumId=:id")
    fun getSongWithAlbumId(id:Int): LiveData<List<Song>>

    @Insert
    fun insertNewSong(song: Song)





}