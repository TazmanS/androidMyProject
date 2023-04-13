package com.tazmans_android.androidmyproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tazmans_android.androidmyproject.MainViewModel
import com.tazmans_android.androidmyproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val mMainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.bDelete.setOnClickListener {
            deleteToken()
        }

        return binding.root
    }

    private fun deleteToken() {
        mMainViewModel.deleteToken()
    }
}