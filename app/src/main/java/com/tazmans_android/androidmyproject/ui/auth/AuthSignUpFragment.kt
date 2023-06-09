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
import androidx.navigation.fragment.NavHostFragment
import com.tazmans_android.androidmyproject.Constants
import com.tazmans_android.androidmyproject.MainViewModel
import com.tazmans_android.androidmyproject.R
import com.tazmans_android.androidmyproject.api.request.SignUpRequest
import com.tazmans_android.androidmyproject.databinding.FragmentAuthSignUpBinding
import kotlinx.coroutines.launch

class AuthSignUpFragment : Fragment() {
    private var _binding: FragmentAuthSignUpBinding? = null
    private val binding get() = _binding!!
    private val mMainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthSignUpBinding.inflate(inflater, container, false)

        binding.bSignUp.setOnClickListener {
            signUp()
        }

        binding.goToSignIn.setOnClickListener {
            goToSignIn()
        }

        return binding.root
    }

    private fun signUp() = with(binding) {
        val isValid = validateFields()

        if (isValid) {
            lifecycleScope.launch {
                val response = mMainViewModel.signUp(createUser())

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
            if (etLogin.text.toString().length < 3) {
                isValid = false
                etLogin.error = Constants.loginError
            }
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

    private fun createUser(): SignUpRequest {
        return SignUpRequest(
            login = binding.etLogin.text.toString(),
            email = binding.etEmail.text.toString(),
            password = binding.etPassword.text.toString(),
            keep_me = binding.cbKeepMe.isActivated,
            email_me = binding.cbEmailMe.isActivated
        )
    }

    private fun goToSignIn() {
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_authSignUpFragment_to_authSignInFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}