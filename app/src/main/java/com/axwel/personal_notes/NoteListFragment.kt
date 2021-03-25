package com.axwel.personal_notes

import androidx.fragment.app.Fragment

class NoteListFragment: Fragment() {

    companion object {
        val TAG = NoteListFragment::class.java.simpleName
        fun newInstance(): NoteListFragment {
            return NoteListFragment()
        }
    }
}