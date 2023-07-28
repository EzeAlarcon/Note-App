package com.example.noterapp.mvvm

import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.noterapp.db.Notes
import com.example.noterapp.db.NotesDao

class NotesRepository(val dao : NotesDao) {

    // mostrar todas las notas

    fun allnotes() : LiveData<List<Notes>> {

        return dao.getAllNotes()

    }

    // insert note

    suspend fun insertNote(notes: Notes){
        dao.insertNotes(notes)
    }

    suspend fun updateNotes(notes: Notes) {
        dao.updateNotes(notes)
    }




    suspend fun deleteNote(notes: Notes){
        dao.deleteNotes(notes)
    }



    suspend fun deleteAll(){
        dao.deleteAll()
    }
}