package com.example.musicapp

import android.app.Activity
import android.graphics.Color
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity,val dataList: List<Data>): RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView
        val title: TextView
        val play: ImageButton
        val pause: ImageButton
        val cardViewPrincipal: CardView
        init {
            image=itemView.findViewById(R.id.musicImage)
            title=itemView.findViewById(R.id.musicTitle)
            play=itemView.findViewById(R.id.btnPlay)
            pause=itemView.findViewById(R.id.btnPause)
            cardViewPrincipal=itemView.findViewById(R.id.ll)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentData=dataList[position]

        holder.title.text=currentData.title
        Picasso.get().load(currentData.album.cover).into(holder.image);

        val mediaPlayer=MediaPlayer.create(context,currentData.preview.toUri())
        holder.play.setOnClickListener{
            mediaPlayer.start()
        }
        holder.pause.setOnClickListener{
            mediaPlayer.pause()
        }
    }


}