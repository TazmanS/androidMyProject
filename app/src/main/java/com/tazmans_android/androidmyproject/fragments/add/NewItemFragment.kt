package com.tazmans_android.androidmyproject.fragments.add

import android.os.Bundle
import android.view.*
import androidx.fragment.app.setFragmentResultListener
import com.tazmans_android.androidmyproject.R
import com.tazmans_android.androidmyproject.activities.MainActivity
import com.tazmans_android.androidmyproject.data.Store
import com.tazmans_android.androidmyproject.data.ToDoItem
import com.tazmans_android.androidmyproject.databinding.FragmentNewItemBinding
import com.tazmans_android.androidmyproject.fragments.BaseFragment
import com.tazmans_android.androidmyproject.fragments.list.ListAdapter
import kotlin.random.Random


class NewItemFragment : BaseFragment(), ListAdapter.Listener {
    private lateinit var binding: FragmentNewItemBinding
    private var currentItem: ToDoItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("item") { _, bundle ->
            val id = bundle.getInt("id")
            val item = Store.findItem(id)
            binding.etTitle.setText(item?.title)
            binding.etDescription.setText(item?.description)
            currentItem = item!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewItemBinding.inflate(inflater, container, false)


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.new_item_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (isValid()) {
            if (currentItem == null) {
                newItem()
            } else {
                updateItem()
            }

            (activity as MainActivity).initHomeFragment()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun isValid(): Boolean = with(binding) {
        return etTitle.text.toString().isNotEmpty() && etDescription.text.toString().isNotEmpty()
    }

    private fun newItem() {
        ListAdapter(this).addItem(
            ToDoItem(
                id = Random.nextInt(0, 99999),
                title = binding.etTitle.text.toString(),
                description = binding.etDescription.text.toString()
            )
        )
    }

    private fun updateItem() {
        currentItem?.copy(
            title = binding.etTitle.text.toString(),
            description = binding.etDescription.text.toString()
        )?.let {
            Store.updateItem(
                it
            )
        }
    }

    override fun onClickItem(item: ToDoItem) {

    }

}