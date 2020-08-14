package com.jetpack.kotlin.vm

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import java.util.*

/**
 * @author  lyc
 * @date    2020/8/12
 * @description:
 */
class LoginViewModel : ViewModel() {
    val phone: ObservableField<String> = ObservableField("");
    val password: ObservableField<String> = ObservableField("");

    fun login() {
        Log.i("AAAAA", "phone = " + phone.get() + " pwd = " + password.get())

        val paramas: Map<String, String> = HashMap<String, String>()

    }
}