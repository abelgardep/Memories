package com.abelgardep.memories.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abelgardep.memories.data.BuildConfig


@Database(
    entities = [
    ],
    version = BuildConfig.dbVersion,
    exportSchema = false
)
abstract class MemoriesDatabase : RoomDatabase()
