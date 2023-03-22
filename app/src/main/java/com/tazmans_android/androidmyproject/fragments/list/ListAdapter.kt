package com.tazmans_android.androidmyproject.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tazmans_android.androidmyproject.R

class ListAdapter :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    val data = mutableListOf("test", "test 111", "test 2222")

    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.tTitle)
        }
    }

    override fun onCreateViewHolder(view: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(view.context).inflate(R.layout.todo_item_row, view, false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addData(newItem: String) {
        data.add(newItem)
        notifyDataSetChanged()
    }

}