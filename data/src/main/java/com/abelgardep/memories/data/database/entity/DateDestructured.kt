package com.abelgardep.memories.data.database.entity

import java.time.LocalDate


data class DateDestructured(
    val day: Int,
    val month: Int,
    val year: Int
)

fun LocalDate.toDateDestructured(): DateDestructured =
    DateDestructured(
        day = this.dayOfMonth,
        month = this.monthValue,
        year = this.year
    )

fun DateDestructured.toLocalDate(): LocalDate =
    LocalDate.of(this.year, this.month, this.day)
