package com.example.noterapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {


    // fetching all the notes
    @Query("SELECT * FROM NOTES")
    fun getAllNotes() : LiveData<List<Notes>>

    // INSERT
    @Insert
    suspend fun insertNotes(notes: Notes)

    // UPDATING

    @Update
    suspend fun updateNotes(notes: Notes)

    // DELETING

    @Delete
    suspend fun deleteNotes(notes: Notes)

    @Query("DELETE FROM NOTES")
    suspend fun deleteAll()



}