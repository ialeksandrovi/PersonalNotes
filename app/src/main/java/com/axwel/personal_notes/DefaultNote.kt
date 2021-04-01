package com.axwel.personal_notes


data class DefaultNote(
        override var title: String,
        override var message: String,
        override var dateCreation: String,
        override var dateLastUpdate: String,
        override val guid: String
): Note