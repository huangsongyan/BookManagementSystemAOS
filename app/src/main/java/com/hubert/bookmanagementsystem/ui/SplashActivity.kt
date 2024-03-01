package com.hubert.bookmanagementsystem.ui

import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.hubert.bookmanagementsystem.base.BaseBindingActivity
import com.hubert.bookmanagementsystem.databinding.ActivitySplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseBindingActivity<ActivitySplashBinding>({
    ActivitySplashBinding.inflate(it)
}) {
    override fun initView() {
        lifecycleScope.launch {
            delay(1500)
            startActivity(Intent(this@SplashActivity, BookActivity::class.java))
            finish()
        }
    }

    override fun initData() {
    }

}