package com.abelgardep.memories.addreminder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate


class AddReminderViewModel : ViewModel() {

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

    fun createReminder(){
        // TODO: Connect with usecases
    }

    private fun enableButtonWhenMandatoryFieldsFilled() {
        _buttonEnabled.value = !_reminderName.value.isNullOrBlank()
    }
}
