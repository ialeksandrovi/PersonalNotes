package com.axwel.personal_notes

import androidx.fragment.app.Fragment

class EditNoteFragment: Fragment() {

    companion object {
        val TAG = EditNoteFragment::class.java.canonicalName ?: "EditNoteFragment"
        fun newInstance(): EditNoteFragment {
            return EditNoteFragment()
        }
    }
}