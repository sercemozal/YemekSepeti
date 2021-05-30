package com.sercem.yemeksepeti.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sercem.yemeksepeti.MainActivity
import com.sercem.yemeksepeti.R
import com.sercem.yemeksepeti.SepetAdapter
import com.sercem.yemeksepeti.databinding.FragmentSepetBinding
import com.sercem.yemeksepeti.entity.Yemekler
import com.sercem.yemeksepeti.viewmodel.AnasayfaFragmentViewModel
import com.sercem.yemeksepeti.viewmodel.SepetFragmentViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.sepet_card_tasarim.*

class SepetFragment : Fragment() {

    private lateinit var viewModel: SepetFragmentViewModel
    private lateinit var tasarim : FragmentSepetBinding
    private lateinit var adapter: SepetAdapter
    private lateinit var sepetListesi: ArrayList<Yemekler>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet, container, false)

        tasarim.sepetFragment = this

        val sepet_array = ((activity as MainActivity)).getArray()

        adapter = SepetAdapter(requireContext(), sepet_array,viewModel)
        tasarim.sepetAdapter = adapter


        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        //Fragment içinde viewModel tanımlaması
        val tempViewModel: SepetFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }
}