package com.tazmans_android.androidmyproject.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tazmans_android.androidmyproject.databinding.ActivityTodoListBinding
import com.tazmans_android.androidmyproject.fragments.BaseFragment

class ListFragment : BaseFragment() {
    private lateinit var binding: ActivityTodoListBinding
    private lateinit var adapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityTodoListBinding.inflate(inflater, container, false)

        initRecycleView()
        return binding.root
    }

    private fun initRecycleView() = with(binding) {
        adapter = ListAdapter()
        rvToDoList.adapter = adapter
        rvToDoList.layoutManager = LinearLayoutManager(activity)
    }
}