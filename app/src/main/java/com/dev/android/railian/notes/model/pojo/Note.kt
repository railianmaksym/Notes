package com.dev.android.railian.notes.model.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Note(
    var title: String,
    var description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}