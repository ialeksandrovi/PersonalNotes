package com.axwel.personal_notes

import java.util.*


data class DefaultNote(
    override var title: String,
    override var message: String,
    override var dateCreation: Date,
    override var dateLastUpdate: Date,
    override val guid: String
): Note