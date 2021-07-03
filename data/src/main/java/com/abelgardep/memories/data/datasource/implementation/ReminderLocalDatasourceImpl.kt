package com.abelgardep.memories.data.datasource.implementation

import com.abelgardep.memories.data.database.dao.ReminderDao
import com.abelgardep.memories.data.database.entity.ReminderEntity
import com.abelgardep.memories.data.database.entity.toDateDestructured
import com.abelgardep.memories.data.database.entity.toLocalDate
import com.abelgardep.memories.data.datasource.IReminderLocalDatasource
import com.abelgardep.memories.domain.model.Reminder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import javax.inject.Inject


class ReminderLocalDatasourceImpl @Inject constructor(
    private val reminderDao: ReminderDao,
) : IReminderLocalDatasource {

    override suspend fun addReminder(reminder: Reminder) {
        reminderDao.addReminder(reminder.toEntity())
    }

    override suspend fun deleteReminder(reminderId: Int) {
        reminderDao.deleteReminder(reminderId)
    }

    override suspend fun getAllReminders(): Flow<List<Reminder>> =
        reminderDao.getAllReminders()
            .map { listOfEntities ->
                listOfEntities.map { entity ->
                    entity.toModel()
                }
            }

    override suspend fun getRemindersFromDay(date: LocalDate): List<Reminder> =
        reminderDao.getRemindersFromDay(
            day = date.dayOfMonth,
            month = date.monthValue
        ).map { entity ->
            entity.toModel()
        }

    override suspend fun getReminderById(reminderId: Int): Reminder =
        reminderDao.getReminderById(reminderId).toModel()

    override suspend fun clear() {
        reminderDao.clear()
    }

    /****************************************************************************************
     *************************************** MAPPERS ****************************************
     ****************************************************************************************/

    private fun ReminderEntity.toModel(): Reminder =
        Reminder(
            id = id,
            name = name,
            description = description,
            date = dateDestructured.toLocalDate()
        )

    private fun Reminder.toEntity(): ReminderEntity =
        ReminderEntity(
            name = name,
            description = description,
            dateDestructured = date.toDateDestructured()
        ).apply { this@toEntity.id?.let { modelId -> id = modelId } }
}
