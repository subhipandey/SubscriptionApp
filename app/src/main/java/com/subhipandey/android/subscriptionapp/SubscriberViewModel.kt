package com.subhipandey.android.subscriptionapp

import android.util.Patterns
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.subhipandey.android.subscriptionapp.database.Subscriber
import com.subhipandey.android.subscriptionapp.database.SubscriberRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel(), Observable {

    val subscribers = repository.subscriber
    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete: Subscriber

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable

    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    private val stateMessage = MutableLiveData<Event<String>>()

    val message: LiveData<Event<String>>
        get() = stateMessage

    init {
        saveOrUpdateButtonText.value = "save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate() {
        if (inputName.value == null) {
            stateMessage.value =
                Event("Please enter subscriber's Name")

        } else if (inputEmail.value == null) {
            stateMessage.value =
                Event("Please enter subscriber's Email")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()) {
            stateMessage.value =
                Event("Please enter a correct email address")

        } else {
            if (isUpdateOrDelete) {
                subscriberToUpdateOrDelete.name = inputName.value!!
                subscriberToUpdateOrDelete.email = inputEmail.value!!
                update(subscriberToUpdateOrDelete)
            } else {
                val name = inputName.value!!
                val email = inputEmail.value!!
                insert(Subscriber(0, name, email))
                inputName.value = null
                inputEmail.value = null
            }

        }


    }

    fun clearAllOrDelete() {
        if (isUpdateOrDelete) {
            delete(subscriberToUpdateOrDelete)
        } else {
            clearAll()
        }


    }

    fun insert(subscriber: Subscriber): Job = viewModelScope.launch {

        var newRowId: Long = repository.insert(subscriber)
        if (newRowId > -1) {
            stateMessage.value =
                Event("Subscriber Added Successfully $newRowId")
        } else {
            stateMessage.value =
                Event("An Error Occurred")
        }
    }

    fun update(subscriber: Subscriber): Job = viewModelScope.launch {
        val noOfRows = repository.update(subscriber)
        if (noOfRows > 0) {
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "ClearAll"
            stateMessage.value =
                Event("$noOfRows Updated Successfully")
        } else {
            stateMessage.value =
                Event("An Error Occurred")
        }

    }

    fun delete(subscriber: Subscriber): Job = viewModelScope.launch {
        val noOfRowsDeleted = repository.delete(subscriber)
        if (noOfRowsDeleted > 0) {
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "ClearAll"
            stateMessage.value =
                Event("$noOfRowsDeleted Removed Successfully")
        } else {
            stateMessage.value =
                Event("An Error Occurred")
        }

    }

    fun clearAll(): Job = viewModelScope.launch {
        val noOfRowsDeleted = repository.deleteAll()
        if (noOfRowsDeleted > 0) {
            stateMessage.value =
                Event("$noOfRowsDeleted Subscriber Removed Successfully")
        } else {
            stateMessage.value =
                Event("An Error Occurred")
        }
    }

    fun initUpdateAndDelete(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}