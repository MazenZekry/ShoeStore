package com.mazen.shoestore.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.mazen.shoestore.R
import com.mazen.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.btnSignIn.setOnClickListener { view: View ->
            if (validate()) {
                view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            }
        }
        binding.btnSignUp.setOnClickListener { view: View ->
            if (validate()) {
                view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.clear()
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
