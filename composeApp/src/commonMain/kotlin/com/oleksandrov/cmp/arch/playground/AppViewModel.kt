package com.oleksandrov.cmp.arch.playground

import com.oleksandrov.cmp.arch.playground.presentation.core.platform.base.viewmodel.BaseViewModel

class AppViewModel : BaseViewModel() {
    fun getString(): String = "Text that is blurred when app is not in focus"
}