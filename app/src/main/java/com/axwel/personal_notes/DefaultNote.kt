package com.axwel.personal_notes

import java.util.*

data class DefaultNote(
        var title: String,
        var message: String,
        var dateCreation: Date,
        var dateLastUpdate: Date
        ): Note