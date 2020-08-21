package com.example.enigma_music.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.enigma_music.R
import com.example.enigma_music.room.album.Album
import com.example.enigma_music.viewModels.AlbumViewModel
import kotlinx.android.synthetic.main.fragment_form_music.*
import kotlinx.android.synthetic.main.fragment_list_music.*
import kotlinx.android.synthetic.main.music_item_layout.*

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentFormMusic.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentFormMusic : Fragment() {

    private val songViewModel by activityViewModels<AlbumViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save_button.setOnClickListener{
            val title = input_album.text.toString()
            val artist = input_artist.text.toString()
            val imgUrl = input_img_album.text.toString()

            val newAlbum = Album(albumTitle = title,artist = artist,imgUrl = imgUrl)
            songViewModel.createNewAlbum(newAlbum)

            Navigation.findNavController(view).navigate(R.id.action_fragmentFormMusic_to_fragmentListMusic)
        }
    }

}