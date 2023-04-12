package com.tazmans_android.androidmyproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tazmans_android.androidmyproject.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    lateinit var binding: FragmentTestBinding
    private val mMainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        
        binding.bTest.setOnClickListener {
            mMainViewModel.setToken("rergerger")
        }

        return binding.root
    }
}