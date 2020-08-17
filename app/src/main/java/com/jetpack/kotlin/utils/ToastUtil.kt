package com.jetpack.kotlin.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import android.view.Gravity
import android.widget.Toast
import com.jetpack.kotlin.MyApplication

/**
 * @author  lyc
 * @date    2020/8/17
 * @description:
 */
class ToastUtil {
    companion object {
        var sToast: Toast? = null

        fun show(text: String?) {
            safeShow(MyApplication.mContext, text, Toast.LENGTH_SHORT)
        }

        private fun safeShow(context: Context?, text: String?, duration: Int) {
            if (Looper.myLooper() != Looper.getMainLooper()) {

            } else {
                showToast(context, text, duration)
            }

        }

        @SuppressLint("ShowToast")
        private fun showToast(context: Context?, text: String?, duration: Int) {
            if (sToast == null) {
                sToast = Toast.makeText(context!!.applicationContext, null, Toast.LENGTH_SHORT)
            } else {
                sToast!!.cancel()
                sToast = Toast.makeText(context!!.applicationContext, null, Toast.LENGTH_SHORT)
            }
            sToast!!.setText(text)
            sToast!!.setGravity(Gravity.CENTER, 0, 0)
            sToast!!.show()
        }
    }
}