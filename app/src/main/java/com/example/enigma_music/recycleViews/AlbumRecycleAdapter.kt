package com.example.enigma_music.recycleViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.enigma_music.R
import com.example.enigma_music.room.album.Album
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.music_item_layout.view.*

class AlbumRecycleAdapter(
    private val albumList: List<Album>,
    private val getActivity: FragmentActivity?
) : RecyclerView.Adapter<albumViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): albumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.music_item_layout, parent, false)
        return albumViewHolder(view)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun onBindViewHolder(holder: albumViewHolder, position: Int) {
        holder.albumTitle.text = albumList[position].albumTitle
        holder.albumArtist.text = albumList[position].artist
        Picasso.with(getActivity).load(albumList[position].imgUrl).into(holder.albumImg)

        val bundle = bundleOf(Pair("albumId",albumList[position].albumId))
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_fragmentListMusic_to_fragmentListSongAlbum, bundle)
        }

    }

}


class albumViewHolder(v: View): RecyclerView.ViewHolder(v){
    val albumImg = v.findViewById<ImageView>(R.id.album_img)
    val albumTitle = v.findViewById<TextView>(R.id.album_title)
    val albumArtist = v.findViewById<TextView>(R.id.album_artist)
}