package com.jetpack.kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jetpack.kotlin.BR
import com.jetpack.kotlin.R
import com.jetpack.kotlin.base.BaseFragment
import com.jetpack.kotlin.databinding.FragmentReviewedListBinding
import com.jetpack.kotlin.databinding.FragmentUploadFailListBinding
import com.jetpack.kotlin.vm.ReviewedListViewModel
import com.jetpack.kotlin.vm.UploadFailViewModel

/**
 * @author  lyc
 * @date    2020/8/7
 * @description:
 */
class UploadFailListFragment : BaseFragment() {
    lateinit var mViewModel: UploadFailViewModel
    lateinit var mDataBinding: FragmentUploadFailListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding = DataBindingUtil.inflate<FragmentUploadFailListBinding>(
            inflater,
            R.layout.fragment_upload_fail_list,
            container,
            false
        )
        mViewModel = UploadFailViewModel()
        mDataBinding.setVariable(BR.viewModel, mViewModel)
        return mDataBinding.root
    }
}