package com.oleksandrov.cmp.arch.playground.common.kotlin.extension

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern

@OptIn(FormatStringsInDatetimeFormats::class)
fun String.parseToLocalDateWith(pattern: String = PATTERN_DATE_TIME): LocalDateTime =
    LocalDateTime.Format { byUnicodePattern(pattern) }.parse(this)
