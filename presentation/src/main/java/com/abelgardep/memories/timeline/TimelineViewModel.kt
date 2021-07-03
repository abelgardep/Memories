package com.abelgardep.memories.timeline

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abelgardep.memories.domain.model.Reminder
import com.abelgardep.memories.domain.usecases.reminder.GetAllRemindersAsStreamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TimelineViewModel @Inject constructor(
    private val getAllRemindersAsStreamUseCase: GetAllRemindersAsStreamUseCase
) : ViewModel() {

    private val _getAllRemindersLiveData: MutableLiveData<TimelineViewState> = MutableLiveData(
        TimelineViewState(listOf())
    )
    val getAllRemindersLiveData: LiveData<TimelineViewState> = _getAllRemindersLiveData

    init {
        getAllReminders()
    }

    private fun getAllReminders() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllRemindersAsStreamUseCase.execute(Unit).collect { useCaseResult ->
                useCaseResult.fold(
                    successAction = { _getAllRemindersLiveData.postValue(TimelineViewState(it)) },
                    failAction = {}
                )
            }
        }
    }

    companion object {
        val initialState = TimelineViewState(listOf())
    }
}


data class TimelineViewState(
    val listOfReminders: List<Reminder>
)
