package com.dev.android.railian.notes.fragment.notesList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dev.android.railian.notes.model.pojo.Note

class NotesListViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: NotesListRepository =
        NotesListRepository(application)
    private var allNotes: LiveData<List<Note>> = repository.getAllNotes()

    fun insert(note: Note) {
        repository.insert(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }
}