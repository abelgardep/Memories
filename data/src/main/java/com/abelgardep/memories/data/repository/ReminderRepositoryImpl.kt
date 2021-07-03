package com.abelgardep.memories.data.repository

import com.abelgardep.memories.data.datasource.IReminderLocalDatasource
import com.abelgardep.memories.domain.model.Reminder
import com.abelgardep.memories.domain.repository.IReminderRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate


class ReminderRepositoryImpl(
    private val reminderLocalDataSource: IReminderLocalDatasource
) : IReminderRepository {
    override suspend fun addReminder(reminder: Reminder) {
        reminderLocalDataSource.addReminder(reminder)
    }

    override suspend fun deleteReminder(reminderId: Int) {
        reminderLocalDataSource.deleteReminder(reminderId)
    }

    override suspend fun getAllReminders(): Flow<List<Reminder>> {
        return reminderLocalDataSource.getAllReminders()
    }

    override suspend fun getReminderById(reminderId: Int): Reminder =
        reminderLocalDataSource.getReminderById(reminderId)

    override suspend fun getRemindersFromDay(day: LocalDate): List<Reminder> {
        return reminderLocalDataSource.getRemindersFromDay(day)
    }
}
