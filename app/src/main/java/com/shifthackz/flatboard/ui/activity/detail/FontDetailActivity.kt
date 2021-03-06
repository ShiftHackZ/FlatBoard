package com.shifthackz.flatboard.ui.activity.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.shifthackz.flatboard.R
import com.shifthackz.flatboard.databinding.ActivityFontDetailBinding
import com.shifthackz.flatboard.base.BaseActivity
import com.shifthackz.flatboard.usecases.AvailableFonts
import com.shifthackz.flatboard.utils.Constants.FONT_SCREEN_TITLE

class FontDetailActivity : BaseActivity<ActivityFontDetailBinding>() {

    override val inflater: (LayoutInflater) -> ActivityFontDetailBinding
        get() = ActivityFontDetailBinding::inflate

    private var fontId: Int = 0
    private lateinit var adapter: FontDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
        initRecyclerView()
        supportActionBar?.title = FONT_SCREEN_TITLE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initUI() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.font_detail_title)
        fontId = intent.getIntExtra(getString(R.string.EXTRAS_FONT_ID), 0)
        binding.btnApplyFont.setOnClickListener {
            val intent = Intent()
            intent.putExtra(getString(R.string.EXTRAS_FONT_ID_SEL), adapter.lastSelectedPosition)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        binding.btnCancelFont.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    private fun initRecyclerView() {
        adapter = FontDetailAdapter(fontId).apply { submitList(AvailableFonts.fontList) }
        binding.rvFontDetail.layoutManager = LinearLayoutManager(this)
        binding.rvFontDetail.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(context: Context, id: Int): Intent {
            val intent = Intent(context, FontDetailActivity::class.java)
            intent.putExtra(context.getString(R.string.EXTRAS_FONT_ID), id)
            return intent
        }
    }
}
