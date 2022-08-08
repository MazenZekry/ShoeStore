package com.mazen.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.mazen.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding:FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLoginBinding.inflate(layoutInflater)
        binding.btnSignIn.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment))
        binding.tvSignUp.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment))
        return binding.root
    }

}