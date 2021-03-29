package com.axwel.personal_notes


import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.axwel.personal_notes.databinding.ItemNoteBinding

class NoteItemViewHolder(
        noteBinding: ItemNoteBinding
): RecyclerView.ViewHolder(noteBinding.root) {
    var defaultItemLayout: ConstraintLayout = noteBinding.clDefaultItem
    var addNewLayout: TextView = noteBinding.tvAddNew
    var title: TextView = noteBinding.tvTitle
    var noteShort: TextView = noteBinding.tvNoteShort


}