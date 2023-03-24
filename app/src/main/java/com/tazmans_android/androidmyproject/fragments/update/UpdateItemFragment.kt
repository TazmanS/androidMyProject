package com.tazmans_android.androidmyproject.fragments.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tazmans_android.androidmyproject.databinding.FragmentUpdateTodoItemBinding
import com.tazmans_android.androidmyproject.fragments.BaseFragment

class UpdateItemFragment : BaseFragment() {
    lateinit var binding: FragmentUpdateTodoItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateTodoItemBinding.inflate(inflater, container, false)

        return binding.root
    }
}