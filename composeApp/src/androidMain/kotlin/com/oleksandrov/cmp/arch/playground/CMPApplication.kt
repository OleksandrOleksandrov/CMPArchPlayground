package com.oleksandrov.cmp.arch.playground

import android.app.Application
import com.oleksandrov.cmp.arch.playground.di.initKoin
import org.koin.android.ext.koin.androidContext

class CMPApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@CMPApplication)
        }
    }
}