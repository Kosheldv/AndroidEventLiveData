package com.kosheldv.androideventlivedata

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kosheldv.eventlivedata.EventLiveData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: EventViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = getViewModel { EventViewModel() }
    }

    override fun onResume() {
        super.onResume()
        setupButtons()
        viewModel.eventLiveData.observeEvent(::handleEvent)
    }

    private fun setupButtons() {
        actionButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        addEventButton.setOnClickListener {
            viewModel.eventLiveData.postEvent("Event")
        }
    }

    private fun handleEvent(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun <T> EventLiveData<T>.observeEvent(action: (T) -> Unit) {
        this.observeEvent(this@MainActivity, action)
    }

    private inline fun <reified T : ViewModel> FragmentActivity.getViewModel(crossinline factory: () -> T): T {
        val vmFactory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
        }
        return ViewModelProvider(this, vmFactory).get(T::class.java)
    }
}
