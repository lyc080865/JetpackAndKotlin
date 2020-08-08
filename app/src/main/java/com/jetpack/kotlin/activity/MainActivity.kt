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
    var mViewModel: MainViewModel? = null
    var mBinding: ActivityMainBinding? = null

    var defaultPage: Int = -1
    var mShowingFragment: Fragment? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initView() {
        mBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mBinding!!.setVariable(BR.viewModel, mViewModel)

        initFragment(0)

        val indexObserver = Observer<Int> { index ->
            initFragment(index)
        }
        mViewModel!!.currentIndex.observe(this, indexObserver)
    }

    /**
     * 初始化Fragment
     */
    private fun initFragment(page: Int) {
        defaultPage = if (defaultPage == page) {
            return
        } else {
            page
        }
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (mShowingFragment != null) {
            fragmentTransaction.hide(mShowingFragment!!)
        }
        when (page) {
            1 -> {
                val fragment =
                    supportFragmentManager.findFragmentByTag("NoReviewListFragment")
                if (fragment == null) {
                    mShowingFragment = NoReviewListFragment()
                    fragmentTransaction.add(
                        R.id.fl_content,
                        mShowingFragment as NoReviewListFragment,
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
                        mShowingFragment as UploadFailListFragment,
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
                        mShowingFragment as ReviewedListFragment,
                        "ReviewedListFragment"
                    )
                } else {
                    mShowingFragment = fragment
                }
            }
        }
        fragmentTransaction.show(mShowingFragment!!)
        fragmentTransaction.commitAllowingStateLoss()

        setTabCheckText(page)
    }

    private fun setTabCheckText(page: Int) {
        mBinding!!.llNoReview.isSelected = false
        mBinding!!.noReviewBtn.isSelected = false
        mBinding!!.tvNoReviewNum.isSelected = false
        mBinding!!.llUploadFail.isSelected = false
        mBinding!!.tvUploadFail.isSelected = false
        mBinding!!.tvUploadFailNum.isSelected = false
        mBinding!!.reviewedBtn.isSelected = false
        when (page) {
            0 -> {
                mBinding!!.llNoReview.isSelected = true
                mBinding!!.noReviewBtn.isSelected = true
                mBinding!!.tvNoReviewNum.isSelected = true
            }
            1 -> {
                mBinding!!.llUploadFail.isSelected = true
                mBinding!!.tvUploadFail.isSelected = true
                mBinding!!.tvUploadFailNum.isSelected = true
            }
            2 -> {
                mBinding!!.reviewedBtn.isSelected = true
            }
        }
    }
}