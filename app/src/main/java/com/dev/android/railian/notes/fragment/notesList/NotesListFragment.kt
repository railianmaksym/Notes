package com.dev.android.railian.notes.fragment.notesList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.android.railian.notes.R
import com.dev.android.railian.notes.adapter.NotesListAdapter
import kotlinx.android.synthetic.main.fragment_notes_list.*

class NotesListFragment : Fragment() {
    private lateinit var noteViewModel: NotesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        noteViewModel = ViewModelProviders.of(this).get(NotesListViewModel::class.java)
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesRecyclerView.layoutManager = LinearLayoutManager(context)
        notesRecyclerView.setHasFixedSize(true)
        notesRecyclerView.adapter = NotesListAdapter()
        noteViewModel.getAllNotes().observe(this,
            Observer {
                if (it.isEmpty()) {
                    showEmptyList()
                } else {
                    (notesRecyclerView.adapter as? NotesListAdapter)?.setNotes(it)
                }
            })
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_notesListFragment_to_addNoteFragment)
        }
    }

    private fun showEmptyList() {
        notesRecyclerView.visibility = View.GONE
        emptyListLayout.visibility = View.VISIBLE
    }
}
