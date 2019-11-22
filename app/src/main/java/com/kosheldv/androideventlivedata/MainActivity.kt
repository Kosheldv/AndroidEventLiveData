package com.kosheldv.androideventlivedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kosheldv.eventlivedata.EventLiveData
import com.kosheldv.eventlivedata.EventObserver
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val eventLiveData = EventLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupButton()
        eventLiveData.postValue("Event")
    }

    override fun onResume() {
        super.onResume()
        eventLiveData.observeEvent(::handleEvent)
    }

    private fun setupButton() {
        actionButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun handleEvent(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    protected fun <T> EventLiveData<T>.observeEvent(action: (T) -> Unit) {
        this.eventLiveData.observe(this@MainActivity, EventObserver {
            it?.apply(action)
        })
    }
}
