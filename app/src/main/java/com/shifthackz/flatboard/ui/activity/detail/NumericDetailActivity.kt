package com.shifthackz.flatboard.ui.activity.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.shifthackz.flatboard.R
import com.shifthackz.flatboard.databinding.ActivityNumericDetailBinding
import com.shifthackz.flatboard.base.BaseActivity
import com.shifthackz.flatboard.usecases.AvailableFonts
import com.shifthackz.flatboard.utils.Constants.NUMERIC_SCREEN_TITLE

class NumericDetailActivity : BaseActivity<ActivityNumericDetailBinding>() {

    override val inflater: (LayoutInflater) -> ActivityNumericDetailBinding
        get() = ActivityNumericDetailBinding::inflate

    private var numId: Int = 0
    private lateinit var adapter: NumericDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
        initRecyclerView()
        supportActionBar?.title = NUMERIC_SCREEN_TITLE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initUI() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.numeric_detail_title)
        numId = intent.getIntExtra(getString(R.string.EXTRAS_NUM_ID), 0)
        binding.btnApplyNumeric.setOnClickListener {
            val intent = Intent()
            intent.putExtra(getString(R.string.EXTRAS_NUM_ID_SEL), adapter.lastSelectedPosition)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        binding.btnCancelNumeric.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    private fun initRecyclerView() {
        adapter = NumericDetailAdapter(numId).apply { submitList(AvailableFonts.numericList) }
        binding.rvNumericDetail.layoutManager = LinearLayoutManager(this)
        binding.rvNumericDetail.adapter = adapter
    }

    companion object {
        fun newInstance(context: Context, id: Int): Intent = Intent(
            context,
            NumericDetailActivity::class.java
        ).apply {
            putExtra(context.getString(R.string.EXTRAS_NUM_ID), id)
        }
    }
}
