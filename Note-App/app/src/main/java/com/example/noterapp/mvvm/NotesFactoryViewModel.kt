package com.example.noterapp.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class NotesFactoryViewModel(private val repository: NotesRepository) : ViewModelProvider.Factory{

    // código repetitivo

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(NotesViewModel::class.java)) {
                return NotesViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel Class")
        }


    }
