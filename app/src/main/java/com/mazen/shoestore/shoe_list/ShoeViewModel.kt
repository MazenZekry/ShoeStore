package com.mazen.shoestore.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mazen.shoestore.model.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    var newShoeName = ""
    var newShoeSize = ""
    var newShoeCompany = ""
    var newShoeDescription = ""

    init {
        _shoeList.value = mutableListOf()
    }

    fun resetDetailData() {
        newShoeName = ""
        newShoeSize = ""
        newShoeCompany = ""
        newShoeDescription = ""
    }

    private fun allShoeDataExist(): Boolean {
        if (newShoeName.isEmpty() || newShoeSize.isEmpty() || newShoeCompany.isEmpty() || newShoeDescription.isEmpty()) {
            return false
        }
        return true
    }

    fun addShoe(): Boolean {
        return if (allShoeDataExist()) {
            _shoeList.value!!.add(
                Shoe(newShoeName, newShoeSize.toDouble(), newShoeCompany, newShoeDescription))
            true
        } else {
            false
        }
    }


}