package com.oleksandrov.cmp.arch.playground.presentation.core.styling

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val version: Int = Build.VERSION.SDK_INT
    override val isPlatform31Plus: Boolean get() = version >= Build.VERSION_CODES.S
}

actual fun platform(): Platform = AndroidPlatform()