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
        val listener: OperationListener,
        val context: Context
): RecyclerView.Adapter<NoteItemViewHolder>() {
    private lateinit var items: List<ItemList>

    fun setItems(noteItems: List<ItemList>) {
        items = noteItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        val noteBinding = ItemNoteBinding.inflate(LayoutInflater.from(context), parent, false)
        return NoteItemViewHolder(noteBinding)
    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        val item = items[position]
        holder.apply {
            if (item is DefaultNoteItemModel) {
                defaultItemLayout.visibility = View.VISIBLE
                addNewLayout.visibility = View.GONE
                setClickListener(defaultItemLayout, item.guid)
                title.text = item.note.title
                noteShort.text = item.note.message
            } else {
                defaultItemLayout.visibility = View.GONE
                addNewLayout.visibility = View.VISIBLE
                setClickListener(addNewLayout, item.guid)
            }
        }


    }

    private fun setClickListener(view: View, guid: String) {
        view.setOnClickListener {
            listener.itemPicked(guid)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}



