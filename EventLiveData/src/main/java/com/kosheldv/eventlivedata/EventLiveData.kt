package com.kosheldv.eventlivedata

import androidx.lifecycle.*

open class EventLiveData<T> : ViewModel() {

    private val _eventLiveData = MutableLiveData<Event<T>>()

    val eventLiveData : LiveData<Event<T>>
        get() = _eventLiveData

    fun postValue(content: T) {
        _eventLiveData.value = Event(content)  // Trigger the event by setting a new Event as a new value
    }
}