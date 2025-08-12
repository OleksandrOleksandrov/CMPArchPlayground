package com.oleksandrov.cmp.arch.playground.common.kotlin

import com.oleksandrov.cmp.arch.playground.common.kotlin.extension.PATTERN_DATE_TIME_ISO_8601_SHORT
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.format.char

object CommonLocalDateFormat {
    val dateFormat = LocalDateTime.Format {
        year()
        char('/')
        monthNumber()
        char('/')
        day()
    }

    @OptIn(FormatStringsInDatetimeFormats::class)
    val dateTimeFormat = LocalDateTime.Format { byUnicodePattern(PATTERN_DATE_TIME_ISO_8601_SHORT) }

    fun parseDate(date: String): String {
        val parsedDate = dateTimeFormat.parse(date)
        return parsedDate.format(dateFormat)
    }
}