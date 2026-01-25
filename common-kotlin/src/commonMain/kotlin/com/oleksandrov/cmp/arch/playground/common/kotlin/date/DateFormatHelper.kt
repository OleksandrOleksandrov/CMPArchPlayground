package com.oleksandrov.cmp.arch.playground.common.kotlin.date

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern

@OptIn(FormatStringsInDatetimeFormats::class)
fun createDateTimeFormatWith(pattern: String): DateTimeFormat<LocalDateTime> =
    LocalDateTime.Format { byUnicodePattern(pattern) }