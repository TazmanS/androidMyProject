package com.tazmans_android.androidmyproject.ui.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tazmans_android.androidmyproject.databinding.FragmentOnBoardingTwoBinding

class OnBoardingTwoFragment : Fragment() {
    private var _binding: FragmentOnBoardingTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoardingTwoBinding.inflate(inflater, container, false)
        initButtonListener()
        return binding.root
    }

    private fun initButtonListener() {
//        binding.bNext.setOnClickListener {
//            NavHostFragment.findNavController(this).navigate(R.id.)
//        }
    }

    companion object {
        @JvmStatic
        fun newInstance() {
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}