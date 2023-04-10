package com.tazmans_android.androidmyproject.ui.auth

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.tazmans_android.androidmyproject.MainRepository
import com.tazmans_android.androidmyproject.api.request.SignUpRequest
import com.tazmans_android.androidmyproject.databinding.FragmentAuthSignUpBinding
import kotlinx.coroutines.launch

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
        val isValid = validateFields()

        if (isValid) {
            lifecycleScope.launch {
                val response = MainRepository().signUp(createUser())

                if (response.data == null) {
                    Toast.makeText(
                        requireActivity(),
                        response.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val token = response.data?.access_token.toString()
                }
            }
        }
    }

    private fun validateFields(): Boolean {
        var isValid = true
        with(binding) {
            if (etLogin.text.toString().length < 3) {
                isValid = false
                etLogin.error = "Login should be at least 3 letters"
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

    private fun createUser(): SignUpRequest {
        return SignUpRequest(
            login = binding.etLogin.text.toString(),
            email = binding.etEmail.text.toString(),
            password = binding.etPassword.text.toString(),
            keep_me = binding.cbKeepMe.isActivated,
            email_me = binding.cbEmailMe.isActivated
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}