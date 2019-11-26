package com.kosheldv.eventlivedata

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData

open class EventLiveData<T> : MutableLiveData<Event<T>>() {

    @MainThread
    override fun postValue(value: Event<T>?) {
        super.postValue(value)
    }
}