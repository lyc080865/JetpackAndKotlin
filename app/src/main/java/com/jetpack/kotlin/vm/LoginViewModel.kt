package com.jetpack.kotlin.vm

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpack.kotlin.bean.UserInfoBean
import com.jetpack.kotlin.repository.UserRepository
import com.jetpack.kotlin.utils.ToastUtil
import com.jetpack.kotlin.utils.UserUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author  lyc
 * @date    2020/8/12
 * @description:
 */
class LoginViewModel : ViewModel() {
    val phone: ObservableField<String> = ObservableField("");
    val password: ObservableField<String> = ObservableField("");

    var userInfo = MutableLiveData<UserInfoBean>()

    private val repository = UserRepository()

    fun login() {
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO) {
                repository.login(phone.get()!!, password.get()!!)
            }
            UserUtil.setUserId(data.data!!.toke)

            if (data.status != 0) {
                ToastUtil.show(data.info)
                return@launch
            }
            userInfo.value = data.data;
        }
    }
}