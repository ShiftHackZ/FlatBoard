package com.shifthackz.flatboard.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<V : ViewBinding> : Fragment() {

    protected lateinit var binding: V

    abstract val inflater: (LayoutInflater, ViewGroup?, Boolean) -> V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = this.inflater.invoke(inflater, container, false)
        return binding.root
    }

    fun onBackPressed(callback: OnBackPressedCallback) {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}