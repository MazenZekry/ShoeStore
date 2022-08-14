package com.mazen.shoestore.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mazen.shoestore.R
import com.mazen.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
    lateinit var binding: FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentInstructionsBinding.inflate(layoutInflater)
        binding.btnNext.setOnClickListener{
            onNext()
        }
        return binding.root
    }

    private fun onNext() {
        findNavController().navigate(R.id.action_instructionsFragment_to_shoeListFragment)
    }
}