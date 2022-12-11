package com.example.mdp_cvbuilderapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdp_cvbuilderapp.databinding.FragmentAboutMeBinding
import com.example.mdp_cvbuilderapp.databinding.FragmentWorkBinding
import kotlinx.android.synthetic.*


class WorkFragment : Fragment(R.layout.fragment_work) {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentWorkBinding

    lateinit var adapter: WorkAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentWorkBinding.bind(view)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        binding.intern.tv1.text=resources.getString(R.string.intern)
        binding.intern.tv2.text=resources.getString(R.string.icog)
        binding.intern.img.setImageResource(R.drawable.icog)

        binding.volenter.tv1.text=resources.getString(R.string.vole)
        binding.volenter.tv2.text=resources.getString(R.string.ears)
        binding.volenter.img.setImageResource(R.drawable.radio)

        recyclerView = view.findViewById(R.id.recycler_view)
        if (context != null) {

            mainViewModel.arrayListLiveData = mutableListOf(

                Work(
                    getString(R.string.kforce),
                    getString(R.string.backend),
                    getString(R.string.feb_2022),
                    R.drawable.kforce
                ),
                Work(
                    getString(R.string.Photon),
                    getString(R.string.back),
                    getString(R.string.sep_2022),
                    R.drawable.photon
                ),
                Work(
                    getString(R.string.woldia),
                    getString(R.string.lecturer),
                    getString(R.string.sep_2019),
                    R.drawable.wld
                )
            )

            //set up the recycler view
            if (::recyclerView.isInitialized) {
                recyclerView.layoutManager = LinearLayoutManager(context)
                adapter = WorkAdapter(requireContext(), mainViewModel.arrayListLiveData)
                recyclerView.adapter = adapter
            }
        }

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener {

            val dialog = WorkDialog()
            dialog.show(parentFragmentManager, WorkDialog::class.java.name)
            val newWork = Work("developer", "google","2023", R.drawable.google)
            mainViewModel.arrayListLiveData.add(newWork)
            adapter?.notifyDataSetChanged()

        }
    }


}