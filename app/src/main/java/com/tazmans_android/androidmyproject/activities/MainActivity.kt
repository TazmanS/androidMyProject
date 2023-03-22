package com.tazmans_android.androidmyproject.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tazmans_android.androidmyproject.adapters.ToDoListAdapter
import com.tazmans_android.androidmyproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ToDoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        adapter = ToDoListAdapter()
        setContentView(binding.root)

        initAdapter()
        setAddButtonListeners()
    }

    private fun initAdapter() = with(binding) {
        rvToDoList.layoutManager = LinearLayoutManager(this@MainActivity)
        rvToDoList.adapter = adapter
    }

    private fun setAddButtonListeners() = with(binding) {
        bAdd.setOnClickListener {
            val text = etInput.text.toString()
            adapter.addData(text)
            etInput.text.clear()
        }
    }
}