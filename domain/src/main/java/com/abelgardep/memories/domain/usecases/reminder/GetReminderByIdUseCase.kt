package com.abelgardep.memories.domain.usecases.reminder

import com.abelgardep.memories.domain.model.Reminder
import com.abelgardep.memories.domain.repository.IReminderRepository
import com.abelgardep.memories.domain.usecases.BaseAsyncUseCase
import javax.inject.Inject


class GetReminderByIdUseCase @Inject constructor(
    private val reminderRepository: IReminderRepository
) : BaseAsyncUseCase<GetReminderByIdUseCase.Params, Reminder?>() {

    override suspend fun call(params: Params) =
        reminderRepository.getReminderById(params.reminderId)

    data class Params(val reminderId: Int)
}
