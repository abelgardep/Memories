package com.abelgardep.memories.extensions

import java.time.LocalDate
import java.time.Month


fun Month.toLegibleStringShort() =
    getDisplayName(java.time.format.TextStyle.SHORT, java.util.Locale.getDefault())
        .trimEnd('.')
        .capitalize(java.util.Locale.getDefault())

fun Month.toLegibleStringLong() =
    getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.getDefault())
        .capitalize(java.util.Locale.getDefault())

fun LocalDate.toLegibleStringNoYear() = "$dayOfMonth ${month.toLegibleStringLong()}"

fun LocalDate.toLegibleStringLong() = "$dayOfMonth ${month.toLegibleStringLong()} $year"

