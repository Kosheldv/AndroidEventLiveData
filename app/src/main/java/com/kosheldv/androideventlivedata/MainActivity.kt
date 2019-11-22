package com.kosheldv.androideventlivedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val eventLiveData = EventLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupButton()
        eventLiveData.postValue("test")
    }

    override fun onResume() {
        super.onResume()
        eventLiveData.eventLiveData.observe(this@MainActivity, EventObserver(::openTaskDetails))
    }

    private fun setupButton() {
        actionButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openTaskDetails(text: String) {
    }
}
