package com.abelgardep.memories.extensions

import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.*


fun Month.toLegibleStringShort() =
    getDisplayName(TextStyle.SHORT, Locale.getDefault())
        .trimEnd('.')
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

fun Month.toLegibleStringLong() =
    getDisplayName(TextStyle.FULL, Locale.getDefault())
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

fun LocalDate.toLegibleStringNoYear() = "$dayOfMonth ${month.toLegibleStringLong()}"

fun LocalDate.toLegibleStringLong() = "$dayOfMonth ${month.toLegibleStringLong()} $year"
