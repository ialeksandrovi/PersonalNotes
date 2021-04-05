package com.axwel.personal_notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.axwel.personal_notes.databinding.FragmentNoteListBinding
import java.text.SimpleDateFormat
import java.util.*

class NoteListFragment: Fragment() {
    lateinit var binding: FragmentNoteListBinding
    lateinit var notesAdapter: NoteListAdapter
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesAdapter = NoteListAdapter(object : OperationListener {
            override fun itemPicked(note: DefaultNote) {
                val navigator = context as NoteDetailsNavigator
                navigator.navigateToDetails(note)
            }
        }, requireContext())
        binding.btnAddNew.setOnClickListener { val navigator = context as NoteDetailsNavigator
            navigator.navigateToDetails(DefaultNote("", "", Date(), Date(), UUID.randomUUID().toString())) }
        val list: MutableList<DefaultNoteItemModel> = mutableListOf()
        list.apply {
            add(DefaultNoteItemModel(DefaultNote("Title1", "MessageMessageMessageMessageMessageMessageMessage", Date(), Date(), UUID.randomUUID().toString())))
            add(DefaultNoteItemModel(DefaultNote("Title1", "MessageMessageMessageMessageMessageMessageMessage", Date(), Date(), UUID.randomUUID().toString())))       }

        recyclerView = binding.rvList
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = notesAdapter
        }
        notesAdapter.setItems(list)
    }

    companion object {
        val TAG = NoteListFragment::class.java.canonicalName ?: "NoteListFragment"
        fun newInstance(): NoteListFragment {
            return NoteListFragment()
        }
    }
}