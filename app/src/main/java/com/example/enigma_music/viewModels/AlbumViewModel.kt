package com.example.enigma_music.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.enigma_music.room.AppRoomDatabase
import com.example.enigma_music.room.album.Album
import com.example.enigma_music.room.album.AlbumRepository
import com.example.enigma_music.room.album.Song
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumViewModel(application: Application): AndroidViewModel(application) {
    private val repository = AlbumRepository(AppRoomDatabase.getDatabaseInstance(application).albumDao())

    fun getAlbumWithSong() = repository.getAlbumWithSong()
    fun getAllAlbum() = repository.getAllAlbum()
    fun getAlbumWithId(id: Int) = repository.getAlbumWithId(id)

    fun createNewAlbum(album:Album) {
        viewModelScope.launch(Dispatchers.IO){
            repository.createNewAlbum(album)
        }
    }

    fun getSongWithAlbumId(id: Int) = repository.getSongWithAlbumId(id)

    fun insertNewSong(song: Song){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertNewSont(song)
        }
    }
}