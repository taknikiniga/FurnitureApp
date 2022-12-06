package com.taknikiniga.furnitureapp.fragments.adapter.layoutbinding

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.databinding.library.baseAdapters.BR

class CustomBinding : Observable {

    @get:Bindable
    var titlevisible: Boolean = false
        set(value) {
            field = value
            listener.notifyChange(this, BR.titlevisible)
        }

    @get:Bindable
    var seeallvisible:Boolean = false
    set(value) {
        field = value
        listener.notifyChange(this,BR.seeallvisible)
    }

    var listener: PropertyChangeRegistry = PropertyChangeRegistry()
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        listener.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        listener.remove(callback)
    }
}