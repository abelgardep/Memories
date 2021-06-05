package com.abelgardep.memories.di

import androidx.room.Room
import com.abelgardep.memories.BuildConfig
import com.abelgardep.memories.data.database.MemoriesDatabase
import com.abelgardep.memories.data.database.migrations.DB_MIGRATIONS
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val localDataSourceModule = module {
    // Room
    single {
        val dbBuilder = Room.databaseBuilder(
            androidContext(),
            MemoriesDatabase::class.java,
            BuildConfig.APPLICATION_ID
        ).apply {
            addMigrations(*DB_MIGRATIONS)
        }
        dbBuilder.build()
    }

}
