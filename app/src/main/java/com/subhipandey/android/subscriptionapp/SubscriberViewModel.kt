package com.subhipandey.android.subscriptionapp

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.subhipandey.android.subscriptionapp.database.Subscriber
import com.subhipandey.android.subscriptionapp.database.SubscriberRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val subscriberRepository = repository.subscriber

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable

    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate(){
        val name = inputName.value!!
        val email = inputEmail.value!!
        insert(Subscriber(0,name,email))
        inputName.value = null
        inputEmail.value = null

    }

    fun clearAllOrDelete(){
        clearAll()


    }

    fun insert(subscriber: Subscriber): Job = viewModelScope.launch {

            repository.insert(subscriber)
        }

    fun update(subscriber: Subscriber): Job = viewModelScope.launch {
        repository.update(subscriber)
    }

    fun delete(subscriber : Subscriber): Job = viewModelScope.launch {
        repository.delete(subscriber)
    }

    fun clearAll(): Job = viewModelScope.launch {
        repository.deleteAll()
    }
}