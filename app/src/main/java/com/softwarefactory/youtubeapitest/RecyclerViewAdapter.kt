package com.softwarefactory.youtubeapitest

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
private var url: String? = null

open class RecyclerViewAdapter(private var urllist:List<String>, private val titleList:List<String>, private val contentList:List<String>)
    : RecyclerView.Adapter<RecyclerViewAdapter.MyHolder>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.items,p0,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return urllist.size
    }

    override fun onBindViewHolder(p0: MyHolder, p1: Int) {
         url = urllist[p1]
        val titles = titleList[p1]
        val contents = contentList[p1]
        p0.title.text = titles
        p0.content.text = contents

    }

    class MyHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var youtubeVideo :YouTubePlayerView
        var title:TextView
        var content:TextView
        var btPlay:Button
        init {
            youtubeVideo = itemView.findViewById(R.id.youtubeVideo) as YouTubePlayerView
            title = itemView.findViewById(R.id.tv_title) as TextView
            content = itemView.findViewById(R.id.tv_content) as TextView
            btPlay = itemView.findViewById(R.id.bt_play) as Button
            btPlay.setOnClickListener {
                youtubeVideo.initialize(PlayerConfiger.API_KEY,object :YouTubePlayer.OnInitializedListener{
                    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
                        p1?.loadVideo(url)
                    }

                    override fun onInitializationFailure(p0: YouTubePlayer.Provider?,p1: YouTubeInitializationResult?) {

                    }

                })
            }
        }
    }
}