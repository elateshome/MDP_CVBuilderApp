package com.example.mdp_cvbuilderapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mdp_cvbuilderapp.databinding.FragmentContactBinding
import com.example.mdp_cvbuilderapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)


        binding.carer.tv1.text = resources.getString(R.string.exp_summary)
        binding.carer.tv2.text = resources.getString(R.string.exp_summary_note)

        binding.workexp.tv1.text = resources.getString(R.string.skill_label)
        binding.workexp.tv2.text = resources.getString(R.string.skills)

        binding.project.tv1.text = resources.getString(R.string.projects_label)
        binding.project.tv2.text = resources.getString(R.string.projects)
        return view

    }
}