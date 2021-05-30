package com.sercem.yemeksepeti.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sercem.yemeksepeti.entity.Yemekler
import com.sercem.yemeksepeti.repo.YemeklerDaoRepository

class SepetFragmentViewModel:ViewModel(){
    var sepetListesi = MutableLiveData<List<Yemekler>>()

}