package com.example.mdp_cvbuilderapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView

//item vew
//current position
abstract class MyViewHolder (iv: View?) : RecyclerView.ViewHolder(
    iv!!
) {
    var cp = 0
    open fun onBind(position: Int) {
        cp = position
    }
}