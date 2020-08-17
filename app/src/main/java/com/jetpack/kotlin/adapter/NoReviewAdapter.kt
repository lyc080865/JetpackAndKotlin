package com.jetpack.kotlin.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.jetpack.kotlin.adapter.vh.ReviewViewHolder
import com.jetpack.kotlin.bean.ReviewInfoBean

/**
 * @author  lyc
 * @date    2020/8/17
 * @description:
 */
class NoReviewAdapter(diffCallback: DiffUtil.ItemCallback<ReviewInfoBean>?):
    PagedListAdapter<ReviewInfoBean, ReviewViewHolder>(diffCallback!!) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    private val DIFF_CALLBACK: DiffUtil.ItemCallback<ReviewInfoBean> =
        object : DiffUtil.ItemCallback<ReviewInfoBean>() {
            override fun areItemsTheSame(oldBean: ReviewInfoBean, newBean: ReviewInfoBean): Boolean {
                return oldBean.id.equals(newBean.id)
            }

            override fun areContentsTheSame(
                oldConcert: ReviewInfoBean,
                newConcert: ReviewInfoBean
            ): Boolean {
                return oldConcert.equals(newConcert)
            }
        }
}