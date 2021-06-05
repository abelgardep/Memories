package com.abelgardep.memories

import android.app.Application
import com.abelgardep.memories.di.localDataSourceModule
import com.abelgardep.memories.di.repositoryModule
import com.abelgardep.memories.di.useCaseModule
import com.abelgardep.memories.di.viewModelModule
import org.koin.core.context.startKoin


class MemoriesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            // module list
            modules(
                listOf(
                    localDataSourceModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}
