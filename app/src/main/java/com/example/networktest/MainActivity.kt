package com.example.networktest

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.networktest.model.presentation.BookResponse
import com.example.networktest.model.remote.executeBooksSearch
import com.example.networktest.model.remote.isDeviceConnected
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {

        //StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //executeBooksSearch("how to cook Mole")

        if (isDeviceConnected())
            executeNetworkCall()
        else
            showError()
    }

    private fun showError() {
        Snackbar.make(findViewById(R.id.tv_display),
        "No network, retry?",
        Snackbar.LENGTH_INDEFINITE)
            .setAction("Retry"){
                Log.d(TAG, "showError: Retried!")
            }.show()
    }

    private fun executeNetworkCall() {
        BookNetwork(findViewById(R.id.tv_display)).execute()
    }

    class BookNetwork(private val display: TextView): AsyncTask<String, Void, BookResponse>(){

        /**
         * Happens in the worker thread
         * 'new Thread(new Runnable(){public void run(){}})'
         */
        override fun doInBackground(vararg p0: String): BookResponse {
            display.text = p0.toString()
            return executeBooksSearch("how to cook Mole")
        }

        /**
         * Happens in the Main Thread
         */
        override fun onPostExecute(result: BookResponse?) {
            super.onPostExecute(result)
            display.text = result.toString() ?: ""
        }
    }

}
