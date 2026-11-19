package com.oleksandrov.cmp.arch.playground.loading.test

import kotlin.reflect.KClass

actual abstract class Runner
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
actual annotation class RunWith(actual val value: KClass<out Runner>)
actual class AndroidJUnit4 : Runner()
