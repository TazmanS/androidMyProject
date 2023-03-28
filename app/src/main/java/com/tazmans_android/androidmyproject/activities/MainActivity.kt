package com.tazmans_android.androidmyproject.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tazmans_android.androidmyproject.R
import com.tazmans_android.androidmyproject.databinding.ActivityMainBinding
import com.tazmans_android.androidmyproject.fragments.FragmentManager
import com.tazmans_android.androidmyproject.fragments.add.NewItemFragment
import com.tazmans_android.androidmyproject.fragments.list.ListFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNavigationListener()
        initHomeFragment()
    }

    fun initHomeFragment() {
        FragmentManager.setFragment(ListFragment(), this@MainActivity)
    }

    private fun setBottomNavigationListener() {
        binding.bNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    FragmentManager.setFragment(ListFragment(), this)
                }
                R.id.nav_new -> {
                    FragmentManager.setFragment(NewItemFragment(), this)
                }
            }
            true
        }
    }
}

// TODO
// Добавить меню +
// Перевести все на фрагменты +
// Несколько экранов для добавление и редактирования заметки
// Удаление заметки
// Переход на navigation
// Перевод на room библиотеку
// Добавление личного кабинета