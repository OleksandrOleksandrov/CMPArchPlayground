package com.oleksandrov.cmp.arch.playground.presentation.core.styling

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun platform(): Platform = IOSPlatform()
