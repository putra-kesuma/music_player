package com.example.enigma_music.recycleViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.enigma_music.R
import com.example.enigma_music.room.album.Song

class SongRecycleAdapter(private val listSong: List<Song>) :
    RecyclerView.Adapter<SongViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_song_layout,parent,false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.songTitle.text = listSong[position].songName
        holder.songDuration.text = listSong[position].songDuration
        holder.imageView.setOnClickListener{
            holder.imageView.setImageResource(R.drawable.ic_baseline_pause_24)
        }
    }

}

class SongViewHolder(view: View): RecyclerView.ViewHolder(view){
    val songTitle =view.findViewById<TextView>(R.id.title_song)
    val songDuration =view.findViewById<TextView>(R.id.duration)
    val imageView = view.findViewById<ImageView>(R.id.button_play)
}