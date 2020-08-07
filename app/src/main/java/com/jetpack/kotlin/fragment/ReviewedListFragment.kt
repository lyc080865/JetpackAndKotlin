package com.jetpack.kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jetpack.kotlin.BR
import com.jetpack.kotlin.R
import com.jetpack.kotlin.base.BaseFragment
import com.jetpack.kotlin.databinding.FragmentNoReviewListBinding
import com.jetpack.kotlin.databinding.FragmentReviewedListBinding
import com.jetpack.kotlin.vm.NoReviewListViewModel
import com.jetpack.kotlin.vm.ReviewedListViewModel

/**
 * @author  lyc
 * @date    2020/8/7
 * @description:
 */
class ReviewedListFragment : BaseFragment() {
    lateinit var mViewModel: ReviewedListViewModel
    lateinit var mDataBinding: FragmentReviewedListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding = DataBindingUtil.inflate<FragmentReviewedListBinding>(
            inflater,
            R.layout.fragment_reviewed_list,
            container,
            false
        )
        mViewModel = ReviewedListViewModel()
        mDataBinding.setVariable(BR.viewModel,mViewModel)
        return mDataBinding.root
    }
}