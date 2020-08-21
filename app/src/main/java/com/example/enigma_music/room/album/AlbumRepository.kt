package com.example.enigma_music.room.album

//album repository nerima album dao
class AlbumRepository(private val albumDao: AlbumDao) {
    fun getAlbumWithSong() = albumDao.getAlbumWithSong()
    fun getAllAlbum() = albumDao.getAllAlbum()
    fun getAlbumWithId(id:Int) = albumDao.getAlbumWithId(id)
    fun createNewAlbum(album: Album) = albumDao.createNewAlbum(album)
    fun getSongWithAlbumId (id: Int) = albumDao.getSongWithAlbumId(id)
    fun insertNewSont(song: Song) = albumDao.insertNewSong(song)

}