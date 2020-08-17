package com.jetpack.kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.jetpack.kotlin.BR
import com.jetpack.kotlin.R
import com.jetpack.kotlin.adapter.NoReviewAdapter
import com.jetpack.kotlin.base.BaseFragment
import com.jetpack.kotlin.databinding.FragmentNoReviewListBinding
import com.jetpack.kotlin.vm.NoReviewListViewModel

/**
 * @author  lyc
 * @date    2020/8/7
 * @description:
 */
class NoReviewListFragment : BaseFragment() {
    var mViewModel: NoReviewListViewModel? = null
    var mBinding: FragmentNoReviewListBinding? = null
    var mAdapter: NoReviewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate<FragmentNoReviewListBinding>(
            inflater,
            R.layout.fragment_no_review_list,
            container,
            false
        )
        mViewModel = NoReviewListViewModel()
        mBinding!!.setVariable(BR.viewModel, mViewModel)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView();
    }

    private fun initView() {
        mAdapter = NoReviewAdapter(null)
        mBinding!!.recyclerView.layoutManager = LinearLayoutManager(activity)
        mBinding!!.recyclerView.adapter


//        mViewModel!!.getNoReviewList();

    }
}