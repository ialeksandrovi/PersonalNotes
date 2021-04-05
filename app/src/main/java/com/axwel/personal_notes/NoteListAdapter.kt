package com.axwel.personal_notes

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.axwel.personal_notes.databinding.ItemNoteBinding

class NoteListAdapter(
    private val listener: OperationListener,
    private val context: Context
): RecyclerView.Adapter<NoteItemViewHolder>() {
    private lateinit var items: List<DefaultNoteItemModel>

    fun setItems(noteItems: List<DefaultNoteItemModel>) {
        items = noteItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        val noteBinding = ItemNoteBinding.inflate(LayoutInflater.from(context), parent, false)
        return NoteItemViewHolder(noteBinding)
    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        val item = items[position]
        holder.apply {
            setClickListener(defaultItemLayout, item.note)
            title.text = item.note.title
            noteShort.text = item.note.message
        }


    }

    private fun setClickListener(view: View, note: DefaultNote) {
        view.setOnClickListener {
            listener.itemPicked(note)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}



