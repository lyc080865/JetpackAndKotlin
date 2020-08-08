package com.jetpack.kotlin.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

/**
 * @author  lyc
 * @date    2020/8/4
 * @description:
 */
class MainViewModel : ViewModel() {
    val currentIndex: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun onTabSelect(index :Int){
        currentIndex.value = index
    }
}