package com.example.mdp_cvbuilderapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class WorkAdapter(val context: Context, val list: MutableList<Work>) :
    RecyclerView.Adapter<MyViewHolder?>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        val itemEvents: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.workitems, viewGroup, false)
        return ViewHolder(itemEvents)
    }

    override fun onBindViewHolder(baseViewHolder: MyViewHolder, i: Int) {
        baseViewHolder.onBind(i)
    }
 //size of the array
    override fun getItemCount(): Int = list.size

    inner class ViewHolder(view: View?) : MyViewHolder(view) {
        var title: TextView? = view?.findViewById(R.id.title)
        var image: ImageView? = view?.findViewById(R.id.logo)
        var workPosition: TextView? = view?.findViewById(R.id.position)
        var duration: TextView? = view?.findViewById(R.id.duration)

        @SuppressLint("NotifyDataSetChanged")
        override fun onBind(p: Int) {
            super.onBind(p)
            val work = list[p]

            image?.setBackgroundResource(work.image)
            title?.text = work.title
            workPosition?.text = work.position
            duration?.text = work.duration
        }
    }
}
