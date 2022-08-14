package com.mazen.shoestore.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mazen.shoestore.model.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoeList= MutableLiveData<MutableList<Shoe>>()
    val shoeList:LiveData<MutableList<Shoe>>
    get()=_shoeList

    private fun addShoe(name:String,company:String,size:Double,description:String){
        val shoe=Shoe(name,size,company,description)
        _shoeList.value!!.add(shoe)
    }
}