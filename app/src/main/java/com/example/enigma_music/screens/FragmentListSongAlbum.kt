package com.example.enigma_music.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enigma_music.R
import com.example.enigma_music.recycleViews.SongRecycleAdapter
import com.example.enigma_music.viewModels.AlbumViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_list_song_album.*


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentListSongAlbum.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentListSongAlbum : Fragment() {
    private val albumViewModel by activityViewModels<AlbumViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_song_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumId = arguments?.getInt("albumId") ?:1

        albumViewModel.getAlbumWithId(albumId).observe(viewLifecycleOwner, Observer {
            artist_name.text = it.artist
            album_name.text = it.albumTitle
            Picasso.with(activity).load(it.imgUrl).into(img_album)
        })

        list_song_recycleview.layoutManager =LinearLayoutManager(activity)
        albumViewModel.getSongWithAlbumId(albumId).observe(viewLifecycleOwner, Observer {
            list_song_recycleview.adapter = SongRecycleAdapter(it)
        })

        add_button_song.setOnClickListener{
            val bundle = bundleOf(Pair("albumId",albumId))
            Navigation.findNavController(it)
                .navigate(R.id.action_fragmentListSongAlbum_to_fragmentAddListSongAlbum,bundle)
        }

    }


}