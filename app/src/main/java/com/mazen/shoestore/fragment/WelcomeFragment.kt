package com.mazen.shoestore.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mazen.shoestore.R
import com.mazen.shoestore.databinding.FragmentLoginBinding
import com.mazen.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
lateinit var binding:FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentWelcomeBinding.inflate(layoutInflater)
        return binding.root
    }
}