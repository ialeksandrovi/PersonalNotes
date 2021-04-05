package com.axwel.personal_notes

import java.util.*

interface Note {
    val guid: String
    val title: String
    val message: String
    val dateLastUpdate: Date
    val dateCreation: Date
}