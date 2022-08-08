package com.mazen.shoestore.fragment

import android.os.Bundle
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.mazen.shoestore.R
import com.mazen.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.btnSignIn.setOnClickListener { view: View ->
            if (validate()) {
                view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            }
        }
        binding.tvSignUp.setOnClickListener { view: View ->
            if (validate()) {
                view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            }
        }
        return binding.root
    }

    private fun validate(): Boolean {
        if (binding.etLoginEmail.text.toString().isEmpty()) {
            binding.etLoginEmail.error = "Please enter your email"
            binding.etLoginEmail.requestFocus()
            return false
        } else if (binding.etLoginPassword.text.toString().isEmpty()) {
            binding.etLoginPassword.setError("Please enter your password",null)
            binding.etLoginPassword.requestFocus()
            return false
        }
        return true

    }
}
