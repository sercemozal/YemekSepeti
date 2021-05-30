package com.sercem.yemeksepeti.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sercem.yemeksepeti.entity.Yemekler
import com.sercem.yemeksepeti.repo.YemeklerDaoRepository

class AnasayfaFragmentViewModel: ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    private val ydaor = YemeklerDaoRepository()

    init {
        yemekleriYukle()
        yemeklerListesi = ydaor.yemekleriGetir()
    }

    fun yemekleriYukle() {
        ydaor.tumYemekleriAl()
    }

    fun ara(aramaKelimesi:String) {
        ydaor.yemekAra(aramaKelimesi)
    }
}