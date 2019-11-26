package com.kosheldv.eventlivedata

import androidx.lifecycle.MutableLiveData

open class EventLiveData<T> : MutableLiveData<Event<T>>()