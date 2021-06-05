package com.abelgardep.memories.domain.repository

import com.abelgardep.memories.domain.model.Reminder
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate


interface IReminderRepository {
    suspend fun addReminder(reminder: Reminder)
    suspend fun deleteReminder(reminderId: Int)

    suspend fun getAllReminders(): Flow<List<Reminder>>
    suspend fun getRemindersFromDay(day: LocalDate): List<Reminder>
}
