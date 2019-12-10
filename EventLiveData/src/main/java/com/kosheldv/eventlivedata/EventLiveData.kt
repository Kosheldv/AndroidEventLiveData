package com.kosheldv.eventlivedata

import androidx.lifecycle.MutableLiveData

open class EventLiveData<T> : MutableLiveData<Event<T>>() {
    fun postEvent(value: T) {
        postValue(Event(value))
    }
}