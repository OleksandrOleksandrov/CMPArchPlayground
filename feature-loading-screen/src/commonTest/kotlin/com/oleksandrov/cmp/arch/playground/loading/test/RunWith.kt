package com.oleksandrov.cmp.arch.playground.loading.test

import kotlin.reflect.KClass

expect abstract class Runner

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
expect annotation class RunWith(val value: KClass<out Runner>)

expect class AndroidJUnit4 : Runner
