package com.sercem.yemeksepeti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.sercem.yemeksepeti.entity.YemekCevap
import com.sercem.yemeksepeti.entity.Yemekler
import com.sercem.yemeksepeti.retrofit.ApiUtils
import com.sercem.yemeksepeti.retrofit.YemeklerDaoInterface
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_tasarim.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var kdaoi : YemeklerDaoInterface
    val sepet_array = arrayListOf<Yemekler>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kdaoi = ApiUtils.getYemeklerDaoInterface()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        NavigationUI.setupWithNavController(bottomNav, navHostFragment.navController)



        tumYemekleriGoster()
        getArray()
    }
    fun getArray():ArrayList<Yemekler> = sepet_array

    fun tumYemekleriGoster(){
        kdaoi.tumYemekler().enqueue(object : Callback<YemekCevap> {
            override fun onResponse(call: Call<YemekCevap>?, response: Response<YemekCevap>) {
                val yemeklerListesi = response.body().yemekler

                for(k in yemeklerListesi){
                    Log.e("*****************", "***************")
                    Log.e("Kişi id", k.yemek_id.toString())
                    Log.e("Kişi ad", k.yemek_adi)
                    Log.e("Kişi tel", k.yemek_fiyat)
                }
            }

            override fun onFailure(call: Call<YemekCevap>?, t: Throwable?) {}
        })
    }

}