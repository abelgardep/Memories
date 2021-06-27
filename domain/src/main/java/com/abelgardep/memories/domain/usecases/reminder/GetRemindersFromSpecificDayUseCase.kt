package com.abelgardep.memories.domain.usecases.reminder

import com.abelgardep.memories.domain.model.Reminder
import com.abelgardep.memories.domain.repository.IReminderRepository
import com.abelgardep.memories.domain.usecases.BaseAsyncUseCase
import java.time.LocalDate
import javax.inject.Inject


class GetRemindersFromSpecificDayUseCase @Inject constructor(
    private val reminderRepository: IReminderRepository
) : BaseAsyncUseCase<GetRemindersFromSpecificDayUseCase.Params, List<Reminder>>() {

    override suspend fun call(params: Params): List<Reminder> =
        reminderRepository.getRemindersFromDay(params.day)

    data class Params(val day: LocalDate)
}
