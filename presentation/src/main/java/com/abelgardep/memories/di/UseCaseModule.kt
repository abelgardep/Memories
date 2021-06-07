package com.abelgardep.memories.di

import com.abelgardep.memories.domain.usecases.reminder.AddReminderUseCase
import com.abelgardep.memories.domain.usecases.reminder.DeleteReminderUseCase
import com.abelgardep.memories.domain.usecases.reminder.GetAllRemindersAsStreamUseCase
import com.abelgardep.memories.domain.usecases.reminder.GetRemindersFromSpecificDayUseCase
import org.koin.dsl.module


val useCaseModule = module {

    single { AddReminderUseCase(get()) }
    single { DeleteReminderUseCase(get()) }
    single { GetAllRemindersAsStreamUseCase(get()) }
    single { GetRemindersFromSpecificDayUseCase(get()) }
}
