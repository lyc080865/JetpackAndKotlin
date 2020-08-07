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
import com.jetpack.kotlin.vm.NoReviewListViewModel

/**
 * @author  lyc
 * @date    2020/8/7
 * @description:
 */
class NoReviewListFragment : BaseFragment() {
    lateinit var mViewModel: NoReviewListViewModel
    lateinit var mDataBinding: FragmentNoReviewListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding = DataBindingUtil.inflate<FragmentNoReviewListBinding>(
            inflater,
            R.layout.fragment_no_review_list,
            container,
            false
        )
        mViewModel = NoReviewListViewModel()
        mDataBinding.setVariable(BR.viewModel,mViewModel)
        return mDataBinding.root
    }
}