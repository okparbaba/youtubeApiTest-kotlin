package com.softwarefactory.youtubeapitest

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.android.youtube.player.YouTubeBaseActivity

class MainActivity : YouTubeBaseActivity(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerViewAdapter:RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter(PlayerConfiger.VIDEO_ID,PlayerConfiger.Titles,PlayerConfiger.Contents)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerViewAdapter

    }
}
