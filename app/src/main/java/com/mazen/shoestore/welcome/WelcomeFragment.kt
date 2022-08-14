package com.mazen.shoestore.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mazen.shoestore.R
import com.mazen.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
lateinit var binding:FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentWelcomeBinding.inflate(layoutInflater)
        binding.btnNext.setOnClickListener{
            onNext()
        }
        return binding.root
    }

    private fun onNext() {
        findNavController().navigate(R.id.action_welcomeFragment_to_instructionsFragment)
    }
}