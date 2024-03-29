package com.abelgardep.memories.domain.usecases.reminder

import com.abelgardep.memories.domain.repository.IReminderRepository
import com.abelgardep.memories.domain.usecases.BaseAsyncUseCase
import javax.inject.Inject


class DeleteReminderUseCase @Inject constructor(
    private val reminderRepository: IReminderRepository
) : BaseAsyncUseCase<DeleteReminderUseCase.Params, Unit>() {

    override suspend fun call(params: Params) = reminderRepository.deleteReminder(params.reminderId)

    data class Params(val reminderId: Int)
}
