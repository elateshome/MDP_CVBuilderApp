package com.example.mdp_cvbuilderapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mdp_cvbuilderapp.databinding.FragmentAboutMeBinding
import com.example.mdp_cvbuilderapp.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.*


class AboutMeFragment : Fragment() {

    private lateinit var binding: FragmentAboutMeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_about_me, container, false)
        binding = FragmentAboutMeBinding.bind(view)


        binding.aboutme.tv1.text = resources.getString(R.string.about_me_label)
        binding.aboutme.tv2.text = resources.getString(R.string.about_me)

        binding.edu1.img.setImageResource(R.drawable.miu)
        binding.edu1.tv1.text = resources.getString(R.string.maharishiinternationaluniversity)
        binding.edu1.tv2.text = resources.getString(R.string.masterofscienceincomputerscience)

        binding.edu2.img.setImageResource(R.drawable.aau)
        binding.edu2.tv1.text = resources.getString(R.string.aau_university)
        binding.edu2.tv2.text = resources.getString(R.string.bachelorsofscienceinelectricalEngineering)

        binding.cert1.img.setImageResource(R.drawable.huawei)
        binding.cert1.tv1.text = resources.getString(R.string.huw)
        binding.cert1.tv2.text = resources.getString(R.string.h_8_8_2018)

        binding.cert2.img.setImageResource(R.drawable.python)
        binding.cert2.tv1.text = resources.getString(R.string.python)
        binding.cert2.tv2.text = resources.getString(R.string.p_6_3_2019)

        binding.cert3.img.setImageResource(R.drawable.c)
        binding.cert3.tv1.text = resources.getString(R.string.c)
        binding.cert3.tv2.text = resources.getString(R.string.c_9_3_2020)

        binding.cert4.img.setImageResource(R.drawable.react)
        binding.cert4.tv1.text = resources.getString(R.string.react)
        binding.cert4.tv2.text = resources.getString(R.string.r_1_20_2021)

        binding.cert5.img.setImageResource(R.drawable.aws)
        binding.cert5.tv2.text = resources.getString(R.string.aws)
        binding.cert5.tv2.text = resources.getString(R.string.a_2_9_2022)


        return view

    }

}