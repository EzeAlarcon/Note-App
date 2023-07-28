package com.example.noterapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBinderMapper
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.noterapp.R
import com.example.noterapp.databinding.FragmentCreateNoteBinding
import com.example.noterapp.db.NotesDatabase
import com.example.noterapp.mvvm.NotesFactoryViewModel
import com.example.noterapp.mvvm.NotesRepository
import com.example.noterapp.mvvm.NotesViewModel


class CreateNoteFragment : Fragment() {

    private lateinit var binding : FragmentCreateNoteBinding
    private lateinit var viewModel: NotesViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño de este fragmento

        (activity as AppCompatActivity).supportActionBar?.setTitle("CREATE NOTE")



        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_note, container, false)

        val dao = NotesDatabase.getInstance(requireContext()).notesDao
        val repostiry = NotesRepository(dao)
        val factory = NotesFactoryViewModel(repostiry)
        viewModel = ViewModelProvider(this, factory)[NotesViewModel::class.java]


        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.saveBtn.setOnClickListener {

            viewModel.addNotes()
            view?.findNavController()?.navigate(R.id.action_createNoteFragment2_to_homeFragment2)

        }

        return binding.root


    }










}