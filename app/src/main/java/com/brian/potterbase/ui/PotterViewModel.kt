package com.brian.potterbase.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brian.potterbase.network.PotterApi
import com.brian.potterbase.network.PotterCharacterItem
import kotlinx.coroutines.launch

class PotterViewModel : ViewModel() {

    private val _potterCharacterItems = MutableLiveData<List<PotterCharacterItem>>()
    val potterCharacterItems : LiveData<List<PotterCharacterItem>> get() = _potterCharacterItems


//    fun getCharacterItems () : MutableLiveData<List<PotterCharacterItem>>{
//        viewModelScope.launch {
//            try {
//                _potter
//                Log.d("ViewModel", "Data fetched")
//            }catch (e : Exception){
//                Log.e("ViewModel", "Error fetching data")
//            }
//        }
//        return _potterCharacterItems
//    }

    fun getCharacter() : List<PotterCharacterItem>?{
        viewModelScope.launch {
            try {
                _potterCharacterItems.postValue(PotterApi.retrofitService.getAllCharacters())
                Log.d("ViewModel", "Data fetched")
            }catch (e : Exception){
                Log.e("ViewModel", "Error fetching data")
            }
        }
        return _potterCharacterItems.value
    }
}