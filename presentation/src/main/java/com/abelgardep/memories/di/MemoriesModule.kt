package com.abelgardep.memories.di

import android.content.Context
import androidx.room.Room
import com.abelgardep.memories.BuildConfig
import com.abelgardep.memories.data.database.MemoriesDatabase
import com.abelgardep.memories.data.database.dao.ReminderDao
import com.abelgardep.memories.data.database.migrations.DB_MIGRATIONS
import com.abelgardep.memories.data.datasource.IReminderLocalDatasource
import com.abelgardep.memories.data.datasource.implementation.ReminderLocalDatasourceImpl
import com.abelgardep.memories.data.repository.ReminderRepositoryImpl
import com.abelgardep.memories.domain.repository.IReminderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MemoriesModule {

    @Singleton
    @Provides
    fun provideMemoriesDatabase(
        @ApplicationContext context: Context
    ): MemoriesDatabase =
        Room.databaseBuilder(
            context,
            MemoriesDatabase::class.java,
            BuildConfig.APPLICATION_ID
        ).apply {
            addMigrations(*DB_MIGRATIONS)
        }.build()

    @Singleton
    @Provides
    fun provideMemoriesDao(
        database: MemoriesDatabase
    ) = database.reminderDao()

    @Singleton
    @Provides
    fun provideMemoriesLocalDataSource(
        dao: ReminderDao
    ) = ReminderLocalDatasourceImpl(dao) as IReminderLocalDatasource

    @Singleton
    @Provides
    fun providesMemoriesRepository(
        reminderLocalDatasource: IReminderLocalDatasource
    ) = ReminderRepositoryImpl(reminderLocalDatasource) as IReminderRepository
}
