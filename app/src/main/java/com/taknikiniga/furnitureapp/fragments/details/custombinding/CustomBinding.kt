package com.taknikiniga.furnitureapp.fragments.details.custombinding

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.databinding.library.baseAdapters.BR

class CustomBinding : Observable {

    @get:Bindable
    var productdescvisible: Boolean? = false
        set(value) {
            field = value
            listener.notifyChange(this, BR.productdescvisible)
        }


    @get:Bindable
    var itemprice: String? = null
        set(value) {
            field = value
            listener.notifyChange(this, BR.itemprice)
        }

    @get:Bindable
    var itemname: String? = null
        set(value) {
            field = value
            listener.notifyChange(this, BR.itemname)
        }

    @get:Bindable
    var itemdesc: String? = null
        set(value) {
            field = value
            listener.notifyChange(this, BR.itemdesc)
        }

    var listener: PropertyChangeRegistry = PropertyChangeRegistry()
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        listener.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        listener.remove(callback)
    }
}