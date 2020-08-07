package com.jetpack.kotlin.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jetpack.kotlin.BR
import com.jetpack.kotlin.base.BaseActivity
import com.jetpack.kotlin.R
import com.jetpack.kotlin.databinding.ActivityMainBinding
import com.jetpack.kotlin.fragment.NoReviewListFragment
import com.jetpack.kotlin.fragment.ReviewedListFragment
import com.jetpack.kotlin.fragment.UploadFailListFragment
import com.jetpack.kotlin.vm.MainViewModel

class MainActivity : BaseActivity() {
    lateinit var mViewModel: MainViewModel
    lateinit var mBinding: ActivityMainBinding

    var defaultPage: Int = 0
    lateinit var mShowingFragment: Fragment;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mBinding.setVariable(BR.viewModel, mViewModel)
    }

    override fun initView() {
        initFragment(0)

        val indexObserver = Observer<Int> { index ->
            initFragment(index)
        }
    }

    /**
     * 初始化Fragment
     */
    private fun initFragment(page: Int) {
        if (defaultPage == page) {
            return
        }
        defaultPage = page
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (mShowingFragment != null) {
            fragmentTransaction.hide(mShowingFragment)
        }
        when (page) {
            1 -> {
                val fragment =
                    supportFragmentManager.findFragmentByTag("NoReviewListFragment")
                if (fragment == null) {
                    mShowingFragment = NoReviewListFragment()
                    fragmentTransaction.add(
                        R.id.fl_content,
                        mShowingFragment,
                        "NoReviewListFragment"
                    )
                } else {
                    mShowingFragment = fragment
                }
            }
            2 -> {
                val fragment =
                    supportFragmentManager.findFragmentByTag("UploadFailListFragment")
                if (fragment == null) {
                    mShowingFragment = UploadFailListFragment()
                    fragmentTransaction.add(
                        R.id.fl_content,
                        mShowingFragment,
                        "UploadFailListFragment"
                    )
                } else {
                    mShowingFragment = fragment
                }
            }
            else -> {
                val fragment =
                    supportFragmentManager.findFragmentByTag("ReviewedListFragment")
                if (fragment == null) {
                    mShowingFragment = ReviewedListFragment()
                    fragmentTransaction.add(
                        R.id.fl_content,
                        mShowingFragment,
                        "ReviewedListFragment"
                    )
                } else {
                    mShowingFragment = fragment
                }
            }
        }
        fragmentTransaction.show(mShowingFragment)
        fragmentTransaction.commitAllowingStateLoss()

        setTabCheckText(page)
    }

    private fun setTabCheckText(page: Int) {
        mBinding.llNoReview.setSelected(false)
        mBinding.noReviewBtn.setSelected(false)
        mBinding.tvNoReviewNum.setSelected(false)
        mBinding.llUploadFail.setSelected(false)
        mBinding.tvUploadFail.setSelected(false)
        mBinding.tvUploadFailNum.setSelected(false)
        mBinding.reviewedBtn.setSelected(false)
        when (page) {
            0 -> {
                mBinding.llNoReview.setSelected(true)
                mBinding.noReviewBtn.setSelected(true)
                mBinding.tvNoReviewNum.setSelected(true)
            }
            1 -> {
                mBinding.llUploadFail.setSelected(true)
                mBinding.tvUploadFail.setSelected(true)
                mBinding.tvUploadFailNum.setSelected(true)
            }
            2 -> {
                mBinding.reviewedBtn.setSelected(true)
            }
        }
    }
}