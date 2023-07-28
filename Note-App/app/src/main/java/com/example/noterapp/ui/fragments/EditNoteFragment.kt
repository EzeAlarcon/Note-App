package com.example.noterapp.ui.fragments

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.appcompat.view.menu.MenuBuilder
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.noterapp.R
import com.example.noterapp.databinding.FragmentEditNoteBinding
import com.example.noterapp.db.Notes
import com.example.noterapp.db.NotesDatabase
import com.example.noterapp.mvvm.NotesFactoryViewModel
import com.example.noterapp.mvvm.NotesRepository
import com.example.noterapp.mvvm.NotesViewModel
import kotlin.properties.Delegates


class EditNoteFragment : Fragment(), MenuProvider {

    lateinit var viewModel: NotesViewModel
    lateinit var binding: FragmentEditNoteBinding

    lateinit var title : String
    lateinit var note: String
    lateinit var sub: String
    lateinit var id: String



    @Suppress("DEPRECATION")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_note, container, false)

        (activity as AppCompatActivity).supportActionBar?.setTitle("EDIT NOTE")



        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.CREATED)

        setHasOptionsMenu(true)




        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

        val dao = NotesDatabase.getInstance(requireContext()).notesDao
        val repostiry = NotesRepository(dao)
        val factory = NotesFactoryViewModel(repostiry)
        viewModel = ViewModelProvider(this, factory)[NotesViewModel::class.java]
        binding.viewModel = viewModel



         title = requireArguments().getString("title").toString()
        sub = requireArguments().getString("sub").toString()
        note = requireArguments().getString("text").toString()

         id = requireArguments().getString("id").toString()



        binding.titleEt.setText(title)
        binding.noteEt.setText(note)
        binding.subet.setText(sub)

        binding.updateNoteBtn.setOnClickListener {

            val newid = id.toInt()
            val newtitle = binding.titleEt.getText()
            val newsub = binding.subet.getText()
            val newnote = binding.noteEt.getText()

            viewModel.editUpdate(newid, newtitle.toString(), newsub.toString(), newnote.toString())
            view.findNavController().navigate(R.id.action_editNoteFragment2_to_homeFragment2)


        }



    }

    @Suppress("DEPRECATION")
    override fun onCreateMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

        val searchbar = menu.findItem(R.id.app_bar_search)
        val delete = menu.findItem(R.id.delete)

        if (delete.isVisible) {

            searchbar.setVisible(false)

        }




    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        val idtodelete = id.toInt()




        if (menuItem.itemId == R.id.delete) {
            viewModel.deleteOneNote(idtodelete, title, sub, note)

            view?.findNavController()?.navigate(R.id.action_editNoteFragment2_to_homeFragment2)

            Toast.makeText(context, "DELETE", Toast.LENGTH_SHORT).show()
        }




        return  true
    }



    }




