package com.mazen.shoestore.shoe_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mazen.shoestore.R
import com.mazen.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {
    lateinit var binding:FragmentShoeListBinding
    lateinit var viewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentShoeListBinding.inflate(layoutInflater)
        viewModel= ViewModelProvider(this)[ShoeViewModel::class.java]
        binding.btnAddShoe.setOnClickListener{
            addShoe()
        }
        return binding.root
    }

    private fun addShoe() {
        findNavController().navigate(R.id.action_shoeListFragment_to_detailsFragment)
    }
}