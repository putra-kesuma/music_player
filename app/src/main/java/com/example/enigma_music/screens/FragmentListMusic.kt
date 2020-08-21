package com.example.enigma_music.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enigma_music.R
import com.example.enigma_music.recycleViews.AlbumRecycleAdapter
import com.example.enigma_music.viewModels.AlbumViewModel
import kotlinx.android.synthetic.main.fragment_list_music.*


/**
 * A simple [Fragment] subclass.
 * Use the [fragmentListMusic.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentListMusic : Fragment() {

    val songViewModel by activityViewModels<AlbumViewModel>()
//    lateinit var songRecycleAdapter: SongRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_music, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        music_recycleView.layoutManager = LinearLayoutManager(activity)

        songViewModel.getAllAlbum().observe(viewLifecycleOwner, Observer {
            music_recycleView.adapter = AlbumRecycleAdapter(it, activity)
        })

        add_button.setOnClickListener{
            Navigation.findNavController(view)
            .navigate(R.id.action_fragmentListMusic_to_fragmentFormMusic)
        }
    }

}