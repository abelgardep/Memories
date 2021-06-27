package com.abelgardep.memories

import android.app.Application
import com.abelgardep.memories.di.localDataSourceModule
import com.abelgardep.memories.di.repositoryModule
import com.abelgardep.memories.di.useCaseModule
import com.abelgardep.memories.di.viewModelModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


@HiltAndroidApp
class MemoriesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            // use the Android context given there
            androidContext(this@MemoriesApp)

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
