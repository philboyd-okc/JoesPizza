package com.example.joespizza.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _state: MutableLiveData<Boolean> = MutableLiveData(false)
    val state: LiveData<Boolean> = _state


}