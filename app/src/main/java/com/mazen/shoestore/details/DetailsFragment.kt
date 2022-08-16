package com.mazen.shoestore.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mazen.shoestore.R
import com.mazen.shoestore.databinding.FragmentDetailsBinding
import com.mazen.shoestore.shoe_list.ShoeViewModel


class DetailsFragment : Fragment() {
    lateinit var binding: FragmentDetailsBinding
    private val viewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        binding.viewModel=viewModel
        viewModel.resetDetailData()

        binding.btnSave.setOnClickListener {
            if (viewModel.finishAddShoe()){
                onSave()
            }
            else{
                Toast.makeText(activity,"Please fill all shoe data",Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnCancel.setOnClickListener {
            onCancel()
        }
        return binding.root
    }

    private fun onSave() {
                findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListFragment())
    }
    private fun onCancel() {
        findNavController().navigate(R.id.action_detailsFragment_to_shoeListFragment)
    }

}