package com.jetpack.kotlin.utils

import android.R
import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.annotation.IntRange
import com.jetpack.kotlin.MyApplication

/**
 * @author  lyc
 * @date    2020/8/8
 * @description:
 */
class BarUtil private constructor() {
    companion object {
        private const val TAG_COLOR = "TAG_COLOR"
        private const val TAG_ALPHA = "TAG_ALPHA"
        private const val TAG_OFFSET = -123

        fun subtractMarginTopEqualStatusBarHeight(view: View) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                return
            }
            val haveSetOffset = view.getTag(TAG_OFFSET)
            if (haveSetOffset == null || !(haveSetOffset as Boolean)) {
                return
            }
            val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams;
            layoutParams.setMargins(
                layoutParams.leftMargin,
                layoutParams.topMargin - statusBarHeight,
                layoutParams.rightMargin,
                layoutParams.bottomMargin
            )
            view.setTag(TAG_OFFSET, false)
        }

        fun setStatusBarAlpha(
            activity: Activity,
            @IntRange(from = 0, to = 255) alpha: Int,
            isDecor: Boolean
        ) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                return
            }
            hideColorView(activity)
            transparentStatusBar(activity)
            addStatusBarAlpha(
                activity,
                alpha,
                isDecor
            )
        }

        private fun addStatusBarAlpha(
            activity: Activity,
            alpha: Int,
            isDecor: Boolean
        ) {
            val parent = if (isDecor) activity.window
                .decorView as ViewGroup else (activity.findViewById<View>(R.id.content) as ViewGroup)
            val fakeStatusBarView =
                parent.findViewWithTag<View>(TAG_ALPHA)
            if (fakeStatusBarView != null) {
                if (fakeStatusBarView.visibility == View.GONE) {
                    fakeStatusBarView.visibility = View.VISIBLE
                }
                fakeStatusBarView.setBackgroundColor(Color.argb(alpha, 0, 0, 0))
            } else {
                parent.addView(
                    createAlphaStatusBarView(
                        parent.context,
                        alpha
                    )
                )
            }
        }

        private fun createAlphaStatusBarView(
            context: Context,
            alpha: Int
        ): View {
            val statusBarView = View(context)
            statusBarView.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                statusBarHeight
            )
            statusBarView.setBackgroundColor(Color.argb(alpha, 0, 0, 0))
            statusBarView.tag = TAG_ALPHA
            return statusBarView
        }

        private fun hideColorView(activity: Activity) {
            val decorView = activity.window.decorView as ViewGroup
            val fakeStatusBarView =
                decorView.findViewWithTag<View>(TAG_COLOR) ?: return
            fakeStatusBarView.visibility = View.GONE
        }

        private fun hideAlphaView(activity: Activity) {
            val decorView = activity.window.decorView as ViewGroup
            val fakeStatusBarView =
                decorView.findViewWithTag<View>(TAG_ALPHA) ?: return
            fakeStatusBarView.visibility = View.GONE
        }

        private fun transparentStatusBar(activity: Activity) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                return
            }
            val window = activity.window
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                val option =
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                window.decorView.systemUiVisibility = option
                window.statusBarColor = Color.TRANSPARENT
            } else {
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            }
        }

        fun setStatusBarLightMode(activity: Activity, isLightMode: Boolean) {
            setStatusBarLightMode(
                activity.window,
                isLightMode
            )
        }

        fun setStatusBarLightMode(window: Window, isLightMode: Boolean) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val decorView = window.decorView
                if (decorView != null) {
                    var vis = decorView.systemUiVisibility
                    vis = if (isLightMode) {
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                        vis or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    } else {
                        vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                    }
                    decorView.systemUiVisibility = vis
                }
            } else {
                MyBarUtil.miuiSetStatusBarLightMode(window, isLightMode)
                MyBarUtil.flymeSetStatusBarLightMode(window, isLightMode)
            }
        }

        /**
         * Return the status bar's height.
         *
         * @return the status bar's height
         */
        val statusBarHeight: Int
            get() {
                val resources: Resources = MyApplication.mContext!!.resources
                val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
                return resources.getDimensionPixelSize(resourceId)
            }

    }
}