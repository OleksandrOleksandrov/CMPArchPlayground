package com.oleksandrov.cmp.arch.playground

import platform.UIKit.UIViewController

interface NativeViewFactory {
    fun createPrivacyBoxUIView(text: String): UIViewController
}