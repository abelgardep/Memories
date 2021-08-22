package com.abelgardep.memories.reminder

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abelgardep.memories.domain.model.Reminder
import com.abelgardep.memories.domain.usecases.reminder.GetReminderByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ReminderDetailsViewModel @Inject constructor(
    private val getReminderByIdUseCase: GetReminderByIdUseCase,
) : ViewModel() {

    private val _reminder: MutableLiveData<Reminder> = MutableLiveData()
    val reminder: LiveData<Reminder> = _reminder

    fun fetchReminderWithId(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getReminderByIdUseCase.execute(
                GetReminderByIdUseCase.Params(reminderId = id)
            )
            Log.d("DETAILS", result.toString())
            result.fold(
                failAction = {},
                successAction = {
                    _reminder.postValue(it)
                }
            )
        }
    }
}
