package com.abelgardep.memories.domain.usecases.reminder

import com.abelgardep.memories.domain.model.Reminder
import com.abelgardep.memories.domain.repository.IReminderRepository
import com.abelgardep.memories.domain.usecases.BaseAsyncUseCase


class AddReminderUseCase(
    private val reminderRepository: IReminderRepository
) : BaseAsyncUseCase<AddReminderUseCase.Params, Unit>() {

    override suspend fun call(params: Params) = reminderRepository.addReminder(params.reminder)

    data class Params(val reminder: Reminder)
}
