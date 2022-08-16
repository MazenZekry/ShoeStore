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
     fun resetDetailData(){
        newShoeName = ""
        newShoeSize = ""
        newShoeCompany = ""
        newShoeDescription = ""
    }
    private fun validateDataExist() : Boolean{
        if(newShoeName.isBlank()||newShoeSize.isBlank()||newShoeCompany.isBlank()||newShoeDescription.isBlank()){
            return false
        }
            return true
    }

    private fun addShoe(name: String, size: String, company: String, description: String) {
        _shoeList.value!!.add(Shoe(name, size.toDouble(), company, description))
    }

    fun finishAddShoe(): Boolean {
        return if (!validateDataExist()) {
            false
        } else{
            addShoe (newShoeName, newShoeSize, newShoeCompany, newShoeDescription)
            true
        }
    }


}