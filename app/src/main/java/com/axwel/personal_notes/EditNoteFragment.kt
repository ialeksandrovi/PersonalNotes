package com.axwel.personal_notes

import android.os.Bundle
import android.text.Editable
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.set
import androidx.fragment.app.Fragment
import com.axwel.personal_notes.databinding.FragmentNoteDetailsBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class EditNoteFragment: Fragment() {
    lateinit var binding: FragmentNoteDetailsBinding
    lateinit var title: EditText
    lateinit var message: EditText
    lateinit var dateCreated: TextView
    lateinit var dateLastUpdated: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNoteDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTitle.setText(arguments?.getString("ARG_NOTE_TITLE"))
        binding.tvTitle.setOnKeyListener { _, keyCode, event ->

            if (event.action == KeyEvent.ACTION_DOWN &&
                    keyCode == KeyEvent.KEYCODE_ENTER
            ) {
                // clear focus and hide cursor from edit text
                binding.tvTitle.clearFocus()
                binding.tvTitle.isCursorVisible = false

                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
        binding.etMessage.setText(requireArguments().getString("ARG_NOTE_MESSAGE"))
        binding.tvDateCreated.text = arguments?.getLong("ARG_NOTE_CREATED")?.let {
            Date(it).toString()
        }
        binding.tvDateLastUpdated.text = arguments?.getLong("ARG_NOTE_UPDATED")?.let {
            Date(it).toString()
        }

    }

    companion object {
        val TAG = EditNoteFragment::class.java.canonicalName ?: "EditNoteFragment"
        fun newInstance(note: DefaultNote): EditNoteFragment {
            return EditNoteFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_NOTE_GUID", note.guid)
                    putString("ARG_NOTE_TITLE", note.title)
                    putString("ARG_NOTE_MESSAGE", note.message)
                    putLong("ARG_NOTE_CREATED", note.dateCreation.time)
                    putLong("ARG_NOTE_UPDATED", note.dateLastUpdate.time)
                }
            }
        }
    }
}