package com.abelgardep.memories.data.repository

import com.abelgardep.memories.data.datasource.IReminderLocalDatasource
import com.abelgardep.memories.domain.repository.IReminderRepository


class ReminderRepositoryImpl(
    private val localDatasource: IReminderLocalDatasource
) : IReminderRepository
