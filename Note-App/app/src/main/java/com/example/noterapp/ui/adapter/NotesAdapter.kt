package com.example.noterapp.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.noterapp.R
import com.example.noterapp.databinding.NoteslistItemBinding
import com.example.noterapp.db.Notes

class NotesAdapter(var notesList: List<Notes>): RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val layoutInfaltor = LayoutInflater.from(parent.context)
        val binding : NoteslistItemBinding
         = DataBindingUtil.inflate(layoutInfaltor,
            R.layout.noteslist_item,
            parent,
            false)
        return MyHolder(binding)

    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.bindTheView(notesList[position])


    }

    fun filteredList(newfilteredlist: ArrayList<Notes>) {

        notesList = newfilteredlist
        notifyDataSetChanged()

    }
}

class MyHolder(val binding : NoteslistItemBinding) : ViewHolder(binding.root) {

    fun bindTheView(notes: Notes){

        binding.noteTitle.text = notes.title
        binding.noteSubtitle.text = notes.subtitle

        binding.listItemLayout.setOnClickListener{
           // clickListener(notes)


            val bundle  = Bundle()
            bundle.putString("title", notes.title)
            bundle.putString("text", notes.notesText)

            bundle.putString("sub", notes.subtitle)
            bundle.putInt("id", notes.id)
            bundle.putString("id", notes.id.toString())


            Navigation.findNavController(it).navigate(R.id.action_homeFragment2_to_editNoteFragment22, bundle)






        }
    }

}
