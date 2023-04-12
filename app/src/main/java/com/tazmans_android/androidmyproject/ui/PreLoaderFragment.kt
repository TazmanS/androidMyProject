package com.tazmans_android.androidmyproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.tazmans_android.androidmyproject.R
import com.tazmans_android.androidmyproject.databinding.FragmentPreLoaderBinding

class PreLoaderFragment : Fragment() {
    private var _binding: FragmentPreLoaderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPreLoaderBinding.inflate(inflater, container, false)

        init()

        return binding.root
    }

    private fun init() {
        NavHostFragment.findNavController(this@PreLoaderFragment)
            .navigate(R.id.action_preLoaderFragment_to_onBoardingOneFragment)
//        CoroutineScope(Dispatchers.Main).launch {
//            delay(1000)
//            NavHostFragment.findNavController(this@PreLoaderFragment)
//                .navigate(R.id.action_preLoaderFragment_to_onBoardingOneFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}