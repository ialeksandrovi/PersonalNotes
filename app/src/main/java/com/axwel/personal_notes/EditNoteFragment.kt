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
        binding.tvTitle.setText("Какой-то заголовок")
        binding.tvTitle.setOnKeyListener { v, keyCode, event ->

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
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        binding.tvDateCreated.text = "Created: \n$currentDate"
        binding.tvDateLastUpdated.text = "Last updated: \n-"

    }

    companion object {
        val TAG = EditNoteFragment::class.java.canonicalName ?: "EditNoteFragment"
        fun newInstance(): EditNoteFragment {
            return EditNoteFragment()
        }
    }
}