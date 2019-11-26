package com.kosheldv.androideventlivedata

import androidx.lifecycle.ViewModel
import com.kosheldv.eventlivedata.EventLiveData

class EventViewModel: ViewModel() {
    val eventLiveData = EventLiveData<String>()
}