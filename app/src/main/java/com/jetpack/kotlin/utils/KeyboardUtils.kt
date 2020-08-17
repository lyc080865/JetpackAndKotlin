package com.jetpack.kotlin.utils

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * @author  lyc
 * @date    2020/8/17
 * @description:
 */
class KeyboardUtils {
    companion object {
        fun hideSoftInput(activity: Activity) {
            val imm =
                activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    ?: return
            var view = activity.currentFocus
            if (view == null) {
                view = View(activity)
            }
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}