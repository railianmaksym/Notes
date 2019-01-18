package com.dev.android.railian.notes.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dev.android.railian.notes.model.pojo.Note

@Dao
interface NoteDao {
    @Insert
    fun insert(note: Note)

    @Query("DELETE FROM notes_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM notes_table ")
    fun getAllNotes(): LiveData<List<Note>>
}