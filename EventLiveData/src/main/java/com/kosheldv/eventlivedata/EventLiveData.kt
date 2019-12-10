package com.kosheldv.eventlivedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

open class EventLiveData<T> : MutableLiveData<Event<T>>() {

    fun postEvent(value: T) {
        postValue(Event(value))
    }

    fun observeEvent(owner: LifecycleOwner, action: (T) -> Unit) {
        observe(owner, EventObserver {
            it?.run(action)
        })
    }
}

