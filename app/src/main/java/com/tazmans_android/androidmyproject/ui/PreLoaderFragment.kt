package com.tazmans_android.androidmyproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.tazmans_android.androidmyproject.R
import com.tazmans_android.androidmyproject.databinding.FragmentPreLoaderBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PreLoaderFragment : Fragment() {
    private var _binding: FragmentPreLoaderBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPreLoaderBinding.inflate(inflater, container, false)

        init()

        return binding.root
    }

    private fun init() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            NavHostFragment.findNavController(this@PreLoaderFragment)
                .navigate(R.id.action_preLoaderFragment2_to_onBoardingOneFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() {
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}