package com.example.noterapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notes::class], version=1)
abstract class NotesDatabase : RoomDatabase() {

    // declarando una referencia abstracta para la interfaz

    abstract  val notesDao: NotesDao

    // instancias únicas

    companion object{
        // ESTO HACE QUE EL CAMPO SEA VISIBLE INMEDIATAMENTE PARA OTRO HILO
        @Volatile
        private var INSTANCE : NotesDatabase? = null
        fun getInstance (context: Context) : NotesDatabase{
            synchronized(this){
                var instance  = INSTANCE

                if (instance == null){

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NotesDatabase::class.java,
                        "notes_database"


                    ).build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }


}