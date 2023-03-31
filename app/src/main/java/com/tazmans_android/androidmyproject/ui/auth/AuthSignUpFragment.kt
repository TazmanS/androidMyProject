package com.tazmans_android.androidmyproject.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tazmans_android.androidmyproject.databinding.FragmentAuthSignUpBinding

class AuthSignUpFragment : Fragment() {
    private var _binding: FragmentAuthSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthSignUpBinding.inflate(inflater, container, false)


        return binding.root
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