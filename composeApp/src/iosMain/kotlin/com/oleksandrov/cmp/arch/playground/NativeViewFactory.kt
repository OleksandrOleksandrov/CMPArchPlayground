package com.oleksandrov.cmp.arch.playground

import platform.UIKit.UIViewController

interface NativeViewFactory {
    fun createPrivacyTextUIView(text: String): UIViewController
}