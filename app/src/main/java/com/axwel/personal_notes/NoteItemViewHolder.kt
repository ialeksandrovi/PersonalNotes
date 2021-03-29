package com.axwel.personal_notes


import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.axwel.personal_notes.databinding.ItemNoteBinding

class NoteItemViewHolder(
        noteBinding: ItemNoteBinding,
        isButtonAddNew: Boolean
): RecyclerView.ViewHolder(noteBinding.root) {
    var defaultItemLayout: ConstraintLayout = noteBinding.clDefaultItem
    var addNewLayout: TextView = noteBinding.tvAddNew


}