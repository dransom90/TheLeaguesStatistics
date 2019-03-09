package com.acodemonkey.theleaguesstatistics

import android.os.AsyncTask.execute
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.romainpiel.shimmer.Shimmer

import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.content_splash.*
import java.util.concurrent.Executors
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {

    var dataReady : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setSupportActionBar(toolbar)

        //loadData()
        startShimmer()
    }

    private fun loadData()
    {
        thread(true, true, null, "Load Data Thread", 1) {
            var count = 0
            while(!dataReady){
                Thread.sleep(1000)
                count++
                if(count == 10) {
                    break
                }
            }
            finish()
        }
    }

    private fun startShimmer()
    {
        val shimmer = Shimmer()
        //shimmer.startDelay = 3000
        shimmer.duration = 3000
        shimmer.start(theLeagueTxt)
    }

}
