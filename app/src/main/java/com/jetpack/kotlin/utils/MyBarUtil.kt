package com.jetpack.kotlin.utils

import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager

/**
 * @author  lyc
 * @date    2020/8/8
 * @description:
 */
class MyBarUtil {

    companion object {

        /**
         * 设置状态栏图标为深色和魅族特定的文字风格，Flyme4.0以上
         * 可以用来判断是否为Flyme用户
         *
         * @param dark 是否把状态栏字体及图标颜色设置为深色
         * @return boolean 成功执行返回true
         */
        fun flymeSetStatusBarLightMode(
            window: Window?,
            dark: Boolean
        ): Boolean {
            var result = false
            if (window != null) {
                try {
                    val lp = window.attributes
                    val darkFlag = WindowManager.LayoutParams::class.java
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON")
                    val meizuFlags = WindowManager.LayoutParams::class.java
                        .getDeclaredField("meizuFlags")
                    darkFlag.isAccessible = true
                    meizuFlags.isAccessible = true
                    val bit = darkFlag.getInt(null)
                    var value = meizuFlags.getInt(lp)
                    value = if (dark) {
                        value or bit
                    } else {
                        value and bit.inv()
                    }
                    meizuFlags.setInt(lp, value)
                    window.attributes = lp
                    result = true
                } catch (e: java.lang.Exception) {
                }
            }
            return result
        }

        /**
         * 需要MIUIV6以上
         *
         * @param dark 是否把状态栏字体及图标颜色设置为深色
         * @return boolean 成功执行返回true
         */
        fun miuiSetStatusBarLightMode(
            window: Window?,
            dark: Boolean
        ): Boolean {
            var result = false
            if (window != null) {
                val clazz: Class<*> = window.javaClass
                try {
                    var darkModeFlag = 0
                    val layoutParams =
                        Class.forName("android.view.MiuiWindowManager\$LayoutParams")
                    val field =
                        layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
                    darkModeFlag = field.getInt(layoutParams)
                    val extraFlagField = clazz.getMethod(
                        "setExtraFlags",
                        Int::class.javaPrimitiveType,
                        Int::class.javaPrimitiveType
                    )
                    if (dark) {
                        extraFlagField.invoke(window, darkModeFlag, darkModeFlag) //状态栏透明且黑色字体
                    } else {
                        extraFlagField.invoke(window, 0, darkModeFlag) //清除黑色字体
                    }
                    result = true
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        //开发版 7.7.13 及以后版本采用了系统API，旧方法无效但不会报错，所以两个方式都要加上
                        if (dark) {
                            window.decorView.systemUiVisibility =
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                        } else {
                            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
                        }
                    }
                } catch (e: Exception) {
                }
            }
            return result
        }
    }
}