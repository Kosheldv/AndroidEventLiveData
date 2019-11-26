package com.kosheldv.androideventlivedata

import androidx.lifecycle.ViewModel

class EventViewModel: ViewModel() {
    val eventLiveData = EventLiveData<String>()
}