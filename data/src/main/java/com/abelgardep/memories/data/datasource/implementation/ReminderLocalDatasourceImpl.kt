package com.abelgardep.memories.data.datasource.implementation

import com.abelgardep.memories.data.database.dao.ReminderDao
import com.abelgardep.memories.data.datasource.IReminderLocalDatasource


class ReminderLocalDatasourceImpl(
    private val reminderDao: ReminderDao,
) : IReminderLocalDatasource
