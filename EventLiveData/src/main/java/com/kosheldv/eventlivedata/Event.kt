package com.kosheldv.eventlivedata

import java.util.concurrent.atomic.AtomicBoolean

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
open class Event<out T>(private val content: T) {

    private val _hasBeenHandled = AtomicBoolean(false)

    private val hasBeenHandled: Boolean
        get() = _hasBeenHandled.get()

    /**
     * Returns the content and prevents its use again.
     */
    fun getEventIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            _hasBeenHandled.set(true)
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun getContent(): T = content
}