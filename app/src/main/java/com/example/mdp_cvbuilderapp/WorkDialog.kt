package com.example.mdp_cvbuilderapp

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider

class WorkDialog : DialogFragment() {
     lateinit var mainViewModel: MainViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = activity?.let {
            val b = AlertDialog.Builder(it)
            val i = requireActivity().layoutInflater
            val view = i.inflate(R.layout.dialog_work, null)

            mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

            b.setView(view).apply {
                view.findViewById<Button>(R.id.btn_cancel)?.setOnClickListener {
                    dismiss()
                }

                view.findViewById<Button>(R.id.btn_add)?.setOnClickListener {
                    val title =
                        view.findViewById<EditText>(R.id.company).text.toString().trim()
                    val position =
                        view.findViewById<EditText>(R.id.position).text.toString().trim()
                    val duration =
                        view.findViewById<EditText>(R.id.duration).text.toString().trim()
                    validation(title, position, duration)

                    val newWork = Work(title,position,duration, R.drawable.aau)
                    mainViewModel.arrayListLiveData.add(newWork)
                    dismiss()
                }

            }
            b.create()
        } ?: throw IllegalStateException("Try again!")

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    fun validation(title: String, position: String, duration: String) {
        if (title.isEmpty()) {
            Toast.makeText(context, "please Provide title", Toast.LENGTH_LONG).show()
            return
        }
        if (position.isEmpty()) {
            Toast.makeText(context, "please Provide position", Toast.LENGTH_LONG).show()
            return
        }
        if (duration.isEmpty()) {
            Toast.makeText(context, "please Provide duration", Toast.LENGTH_LONG).show()
            return
        }
    }


}