package com.axwel.personal_notes

data class DefaultNoteItemModel(
        val note: Note
        ) : ItemList {
    override val guid: String
        get() = note.guid
}