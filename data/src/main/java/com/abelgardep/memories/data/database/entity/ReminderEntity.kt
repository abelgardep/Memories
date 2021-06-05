package com.abelgardep.memories.data.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abelgardep.memories.data.database.entity.ReminderEntity.Companion.TABLE_NAME


@Entity(
    tableName = TABLE_NAME
)
data class ReminderEntity(
    val name: String,
    val description: String?,
    @Embedded
    val dateDestructured: DateDestructured
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    companion object {
        const val TABLE_NAME = "reminder"
    }
}
