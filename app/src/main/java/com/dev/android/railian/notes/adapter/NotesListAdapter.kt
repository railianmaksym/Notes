package com.dev.android.railian.notes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.android.railian.notes.R
import com.dev.android.railian.notes.model.pojo.Note
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_note.*

class NotesListAdapter : RecyclerView.Adapter<NotesListAdapter.NoteViewHolder>() {
    private var notes: List<Note> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notes[position]
        holder.title.text = currentNote.title
        holder.description.text = currentNote.description
    }

    fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    class NoteViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer
}