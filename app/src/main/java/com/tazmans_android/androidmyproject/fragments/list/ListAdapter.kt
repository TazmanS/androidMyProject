package com.tazmans_android.androidmyproject.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tazmans_android.androidmyproject.R
import com.tazmans_android.androidmyproject.data.Store
import com.tazmans_android.androidmyproject.data.ToDoItem
import com.tazmans_android.androidmyproject.databinding.TodoItemRowBinding

class ListAdapter(private val listener: Listener) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = TodoItemRowBinding.bind(view)

        fun setDataItem(item: ToDoItem, listener: Listener) = with(binding) {
            tTitle.text = item.title

            itemView.setOnClickListener {
                listener.onClickItem(item)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.todo_item_row, viewGroup, false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.setDataItem(Store.data[position], listener)
    }

    override fun getItemCount(): Int {
        return Store.data.size
    }


    public fun addItem(newItem: ToDoItem) {
        Store.addItem(newItem)
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClickItem(item: ToDoItem)
    }

}