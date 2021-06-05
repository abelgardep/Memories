package com.abelgardep.memories.data.datasource

import com.abelgardep.memories.domain.model.Reminder
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate


interface IReminderLocalDatasource {
    suspend fun addReminder(reminder: Reminder)
    suspend fun deleteReminder(reminderId: Int)

    suspend fun getAllReminders(): Flow<List<Reminder>>
    suspend fun getRemindersFromDay(date: LocalDate): List<Reminder>

    suspend fun clear()
}
