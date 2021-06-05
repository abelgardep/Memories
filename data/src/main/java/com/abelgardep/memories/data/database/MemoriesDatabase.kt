package com.abelgardep.memories.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abelgardep.memories.data.BuildConfig
import com.abelgardep.memories.data.database.dao.ReminderDao
import com.abelgardep.memories.data.database.entity.ReminderEntity


@Database(
    entities = [
        ReminderEntity::class,
    ],
    version = BuildConfig.dbVersion,
    exportSchema = false
)
abstract class MemoriesDatabase : RoomDatabase() {

    abstract fun reminderDao(): ReminderDao
}
