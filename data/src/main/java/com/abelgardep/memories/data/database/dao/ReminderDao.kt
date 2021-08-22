package com.abelgardep.memories.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abelgardep.memories.data.database.entity.ReminderEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ReminderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addReminder(reminder: ReminderEntity)

    @Query(DELETE_REMINDER_WITH_ID)
    fun deleteReminder(reminderId: Int)

    @Query(GET_ALL_REMINDERS_QUERY)
    fun getAllReminders(): Flow<List<ReminderEntity>>

    @Query(GET_REMINDER_BY_ID_QUERY)
    fun getReminderById(reminderId: Int): ReminderEntity?

    @Query(GET_REMINDERS_FROM_DAY_QUERY)
    fun getRemindersFromDay(day: Int, month: Int): List<ReminderEntity>

    @Query(CLEAR_QUERY)
    fun clear()

    companion object {
        private const val DELETE_REMINDER_WITH_ID =
            "DELETE FROM ${ReminderEntity.TABLE_NAME} " +
                    "WHERE id = :reminderId"

        private const val GET_ALL_REMINDERS_QUERY =
            "SELECT * FROM ${ReminderEntity.TABLE_NAME} " +
                    "ORDER BY month, day"

        private const val GET_REMINDER_BY_ID_QUERY =
            "SELECT * FROM ${ReminderEntity.TABLE_NAME} " +
                    "WHERE id = :reminderId"

        private const val GET_REMINDERS_FROM_DAY_QUERY =
            "SELECT * FROM ${ReminderEntity.TABLE_NAME} " +
                    "WHERE day = :day " +
                    "AND month = :month " +
                    "ORDER BY day"

        private const val CLEAR_QUERY = "DELETE FROM ${ReminderEntity.TABLE_NAME}"
    }
}
