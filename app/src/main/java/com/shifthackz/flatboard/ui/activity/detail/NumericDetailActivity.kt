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
import com.shifthackz.flatboard.ui.base.BaseActivity
import com.shifthackz.flatboard.ui.recyclerview.adapter.NumericDetailAdapter
import com.shifthackz.flatboard.usecases.AvailableFonts
import java.util.*

class NumericDetailActivity : BaseActivity<ActivityNumericDetailBinding>() {

    override val inflater: (LayoutInflater) -> ActivityNumericDetailBinding
        get() = ActivityNumericDetailBinding::inflate

    private var numId: Int = 0
    private lateinit var adapter : NumericDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
        initRecyclerView()
        supportActionBar?.title = "\uD835\uDC7A\uD835\uDC86\uD835\uDC8D\uD835\uDC86\uD835\uDC84\uD835\uDC95 \uD835\uDC8F\uD835\uDC96\uD835\uDC8E\uD835\uDC83\uD835\uDC86\uD835\uDC93\uD835\uDC94 \uD835\uDC94\uD835\uDC86\uD835\uDC95"
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initUI() {
        Objects.requireNonNull(supportActionBar)?.setDisplayHomeAsUpEnabled(true)
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
        val manager = LinearLayoutManager(this)
        adapter = NumericDetailAdapter(this, AvailableFonts.numericList, numId)
        binding.rvNumericDetail.layoutManager = manager
        binding.rvNumericDetail.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(context: Context, id: Int): Intent {
            val intent = Intent(context, NumericDetailActivity::class.java)
            intent.putExtra(context.getString(R.string.EXTRAS_NUM_ID), id)
            return intent
        }
    }
}
