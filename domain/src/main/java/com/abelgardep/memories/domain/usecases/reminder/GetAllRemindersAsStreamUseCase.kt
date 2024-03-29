package com.abelgardep.memories.domain.usecases.reminder

import com.abelgardep.memories.domain.model.Reminder
import com.abelgardep.memories.domain.repository.IReminderRepository
import com.abelgardep.memories.domain.usecases.BaseFlowUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetAllRemindersAsStreamUseCase @Inject constructor(
    private val reminderRepository: IReminderRepository
) : BaseFlowUseCase<Unit, List<Reminder>>() {

    override suspend fun call(params: Unit): Flow<List<Reminder>> =
        reminderRepository.getAllReminders()
}
