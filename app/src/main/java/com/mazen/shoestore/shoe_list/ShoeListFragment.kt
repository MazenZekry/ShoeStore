package com.mazen.shoestore.shoe_list

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.mazen.shoestore.R
import com.mazen.shoestore.databinding.FragmentShoeListBinding
import com.mazen.shoestore.databinding.ShoeItemListBinding
import com.mazen.shoestore.model.Shoe

class ShoeListFragment : Fragment() {
    lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this

        viewModel.shoeList.observe(viewLifecycleOwner) {
            for (shoe in viewModel.shoeList.value!!) {
                addShoe(shoe)
            }
        }
        binding.btnAddShoe.setOnClickListener {
            addNewShoeDetails()
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun addNewShoeDetails() {
        findNavController().navigate(R.id.action_shoeListFragment_to_detailsFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.loginFragment -> {
                findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addShoe(shoe: Shoe) {
        val shoeItemBinding = ShoeItemListBinding.inflate(layoutInflater)
        shoeItemBinding.shoeItem = shoe
        binding.innerLayout.addView(shoeItemBinding.root)

    }
}