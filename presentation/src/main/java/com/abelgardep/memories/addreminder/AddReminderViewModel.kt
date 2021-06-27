package com.abelgardep.memories.addreminder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abelgardep.memories.domain.model.Reminder
import com.abelgardep.memories.domain.usecases.reminder.AddReminderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject


@HiltViewModel
class AddReminderViewModel @Inject constructor(
    private val addReminderUseCase: AddReminderUseCase
) : ViewModel() {

    private val _reminderName: MutableLiveData<String> = MutableLiveData("")
    val reminderName: LiveData<String> = _reminderName

    private val _reminderDescription: MutableLiveData<String> = MutableLiveData("")
    val reminderDescription: LiveData<String> = _reminderDescription

    private val _reminderDate: MutableLiveData<LocalDate> = MutableLiveData(LocalDate.now())
    val reminderDate: LiveData<LocalDate> = _reminderDate

    private val _buttonEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val buttonEnabled: LiveData<Boolean> = _buttonEnabled

    fun onNameChange(nameUpdated: String) {
        _reminderName.value = nameUpdated
        enableButtonWhenMandatoryFieldsFilled()
    }

    fun onDescriptionChange(descriptionUpdated: String) {
        _reminderDescription.value = descriptionUpdated
        enableButtonWhenMandatoryFieldsFilled()
    }

    fun onDateSet(date: LocalDate) {
        _reminderDate.value = date
        enableButtonWhenMandatoryFieldsFilled()
    }

    fun createReminder() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = addReminderUseCase.execute(
                AddReminderUseCase.Params(
                    Reminder(
                        id = null,
                        name = _reminderName.value!!,
                        description = _reminderDescription.value,
                        date = _reminderDate.value!!
                    )
                )
            )
        }
    }

    private fun enableButtonWhenMandatoryFieldsFilled() {
        _buttonEnabled.value = !_reminderName.value.isNullOrBlank()
    }
}
