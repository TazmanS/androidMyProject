package com.tazmans_android.androidmyproject.ui.auth

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.tazmans_android.androidmyproject.Constants
import com.tazmans_android.androidmyproject.MainViewModel
import com.tazmans_android.androidmyproject.api.request.SignInRequest
import com.tazmans_android.androidmyproject.databinding.FragmentAuthSignInBinding
import kotlinx.coroutines.launch

class AuthSignInFragment : Fragment() {
    private var _binding: FragmentAuthSignInBinding? = null
    private val binding get() = _binding!!

    private val mMainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthSignInBinding.inflate(inflater, container, false)

        binding.bSignIn.setOnClickListener {
            signIn()
        }

        return binding.root
    }

    private fun signIn() {
        val isValid = validateFields()
        if (isValid) {
            lifecycleScope.launch {
                val response = mMainViewModel.signIn(createRequest())
                if (response.data == null) {
                    Toast.makeText(
                        requireActivity(),
                        response.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val token = response.data?.access_token.toString()
                    mMainViewModel.setToken(token)
                }
            }
        }
    }

    private fun validateFields(): Boolean {
        var isValid = true
        with(binding) {
            if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()) {
                isValid = false
                etEmail.error = Constants.emailError
            }
            if (etPassword.text.toString().length < 6) {
                isValid = false
                etPassword.error = Constants.passwordError
            }
        }

        return isValid
    }

    private fun createRequest(): SignInRequest {
        return SignInRequest(
            email = binding.etEmail.text.toString(),
            password = binding.etPassword.text.toString()
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}