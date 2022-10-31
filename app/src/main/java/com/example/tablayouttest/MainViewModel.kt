package com.example.tablayouttest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val plant = MutableLiveData<PlantModel>()
}