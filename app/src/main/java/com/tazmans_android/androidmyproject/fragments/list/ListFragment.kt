package com.tazmans_android.androidmyproject.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import com.tazmans_android.androidmyproject.R
import com.tazmans_android.androidmyproject.data.ToDoItem
import com.tazmans_android.androidmyproject.databinding.FragmentTodoListBinding
import com.tazmans_android.androidmyproject.fragments.BaseFragment
import com.tazmans_android.androidmyproject.fragments.add.NewItemFragment

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

    override fun onClickItem(item: ToDoItem) {
        setFragmentResult("item", bundleOf("id" to item.id))

        val transition = activity?.supportFragmentManager?.beginTransaction()
        transition?.replace(R.id.placeholder, NewItemFragment())
        transition?.commit()
    }
}