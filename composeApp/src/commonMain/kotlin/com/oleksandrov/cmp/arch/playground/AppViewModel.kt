package com.oleksandrov.cmp.arch.playground

import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {
    fun getString(): String = "Text that is blurred when app is not in focus"
}