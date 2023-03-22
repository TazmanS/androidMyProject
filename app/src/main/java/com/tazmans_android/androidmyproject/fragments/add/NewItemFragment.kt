package com.tazmans_android.androidmyproject.fragments.add

import android.os.Bundle
import android.util.Log
import android.view.*
import com.tazmans_android.androidmyproject.R
import com.tazmans_android.androidmyproject.databinding.ActivityNewItemBinding
import com.tazmans_android.androidmyproject.fragments.BaseFragment

class NewItemFragment : BaseFragment() {
    private lateinit var binding: ActivityNewItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityNewItemBinding.inflate(inflater, container, false)


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.new_item_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.v("MyTag", item.itemId.toString())

        return super.onOptionsItemSelected(item)
    }
}