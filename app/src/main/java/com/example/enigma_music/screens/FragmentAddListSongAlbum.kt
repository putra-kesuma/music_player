package com.example.enigma_music.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.enigma_music.R
import com.example.enigma_music.room.album.Song
import com.example.enigma_music.viewModels.AlbumViewModel
import kotlinx.android.synthetic.main.fragment_add_list_song_album.*
import kotlinx.android.synthetic.main.fragment_form_music.*


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAddListSongAlbum.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAddListSongAlbum : Fragment() {
    private val albumViewModel by activityViewModels<AlbumViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_list_song_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val albumId = arguments?.getInt("albumId") ?: 1
        save_button_song.setOnClickListener {
            val title  = input_song_title.text.toString()
            val duration = input_duration.text.toString()

            if (title == "" || duration == "") {
                return@setOnClickListener
            }

            albumViewModel.insertNewSong(
                Song(
                    songName = title,
                    songDuration = duration,
                    songAlbumId = albumId
                )
            )

            Navigation.findNavController(view).navigate(R.id.action_fragmentAddListSongAlbum_to_fragmentListSongAlbum)
        }


    }
}