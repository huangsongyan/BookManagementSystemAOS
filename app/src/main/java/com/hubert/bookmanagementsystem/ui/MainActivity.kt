package com.hubert.bookmanagementsystem.ui;

import android.content.Intent
import com.hubert.bookmanagementsystem.base.BaseBindingActivity
import com.hubert.bookmanagementsystem.databinding.ActivityMainBinding

class MainActivity : BaseBindingActivity<ActivityMainBinding>({
    ActivityMainBinding.inflate(it)
}) {
    override fun initView() {
        binding.enterSys.setOnClickListener {
            startActivity(Intent(this@MainActivity, BookActivity::class.java))
        }
    }

    override fun initData() {
    }
}
