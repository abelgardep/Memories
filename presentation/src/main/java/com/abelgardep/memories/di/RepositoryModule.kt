package com.abelgardep.memories.di

import com.abelgardep.memories.data.repository.ReminderRepositoryImpl
import com.abelgardep.memories.domain.repository.IReminderRepository
import org.koin.dsl.module


val repositoryModule = module {

    single<IReminderRepository> { ReminderRepositoryImpl(get()) }
}
