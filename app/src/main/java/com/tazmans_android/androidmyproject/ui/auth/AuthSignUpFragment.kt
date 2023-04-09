package com.tazmans_android.androidmyproject.ui.auth

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tazmans_android.androidmyproject.databinding.FragmentAuthSignUpBinding

class AuthSignUpFragment : Fragment() {
    private var _binding: FragmentAuthSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthSignUpBinding.inflate(inflater, container, false)

        binding.bSignUp.setOnClickListener {
            signUp()
        }

        return binding.root
    }

    private fun signUp() = with(binding) {
        var isValid = validateFields()

        if (isValid) {
            Log.v("MyTag", isValid.toString())
        } else {
            Log.v("MyTag", isValid.toString())
        }

    }

    private fun validateFields(): Boolean {
        var isValid = true
        with(binding) {
            if (etLogin.text.toString().length < 5) {
                isValid = false
                etLogin.error = "Login should be at least 5 letters"
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()) {
                isValid = false
                etEmail.error = "Wrong email type"
            }
            if (etPassword.text.toString().length < 6) {
                isValid = false
                etPassword.error = "Password has to be at least 6 symbols"
            }
        }

        return isValid
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}