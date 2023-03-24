package com.tazmans_android.androidmyproject.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tazmans_android.androidmyproject.databinding.FragmentTodoListBinding
import com.tazmans_android.androidmyproject.fragments.BaseFragment

class ListFragment : BaseFragment(), ListAdapter.Listener {
    private lateinit var binding: FragmentTodoListBinding
    private lateinit var adapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoListBinding.inflate(inflater, container, false)
        adapter = ListAdapter(this)
        initRecycleView()

        return binding.root
    }

    private fun initRecycleView() = with(binding) {
        rvToDoList.adapter = adapter
        rvToDoList.layoutManager = LinearLayoutManager(activity)
    }
//
//    fun addItemToList(newItem: ToDoItem) {
//        adapter.addData(newItem)
//    }
}