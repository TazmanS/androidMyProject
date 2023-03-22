package com.tazmans_android.androidmyproject.fragments.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tazmans_android.androidmyproject.databinding.ActivityNewItemBinding
import com.tazmans_android.androidmyproject.fragments.BaseFragment

class NewItemFragment : BaseFragment() {
    private lateinit var binding: ActivityNewItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityNewItemBinding.inflate(inflater, container, false)
        return binding.root
    }
}