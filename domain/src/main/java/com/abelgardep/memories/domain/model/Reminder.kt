package com.abelgardep.memories.domain.model

import java.time.LocalDate


data class Reminder(
    val id: Int?,
    val name: String,
    val description: String?,
    val date: LocalDate
)
