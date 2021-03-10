package com.rasel.android_utils

import android.app.Activity
import com.rasel.basicutils.BaseApplication
import com.rasel.basicutils.log.Logger

class MainApplication: BaseApplication() {

    override fun onEnterBackground(activity: Activity) {
        Logger.debugLogInfo("onEnterBackground")
    }

    override fun onReturnForeground(activity: Activity) {
        Logger.debugLogInfo("onReturnedForeground")
    }
}