package com.sercem.yemeksepeti.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sercem.yemeksepeti.entity.Yemekler

class YemekDetayFragmentViewModel : ViewModel(){

    var sepetListesi = MutableLiveData<List<Yemekler>>()
}