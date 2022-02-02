package com.example.networktest

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.networktest.model.remote.executeBooksSearch
import com.example.networktest.model.remote.isDeviceConnected

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        executeBooksSearch("how to cook Mole")

//        if (isDeviceConnected())
//            executeNetworkCall()
//        else
//            showError()
    }

    private fun showError() {
        TODO("Not yet implemented")
    }

    private fun executeNetworkCall() {
        BookNetwork.execute()
    }

    object BookNetwork: AsyncTask<Void, Void, Void?>(){

        /**
         * Happen in the worker thread
         * 'new Thread(new Runnable(){public void run(){}})'
         */
        override fun doInBackground(vararg p0: Void?): Void? {
            executeBooksSearch("how to cook Mole")
            return null
        }
    }

}
