package com.rasel.android_utils

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rasel.android_utils.databases.AppStorage
import com.rasel.basicutils.AppStatus
import com.rasel.basicutils.AppStatusCallback
import com.rasel.basicutils.log.Logger
import com.rasel.basicutils.log.Toaster

class MainActivity : AppCompatActivity() {

    private val activityCallback = object : AppStatusCallback {
        override fun onAppStatusChanged(appStatus: AppStatus, activity: Activity) {
            when(appStatus) {
                AppStatus.RETURNED_TO_FOREGROUND -> {
                    //App returned from background
                    Logger.debugLogInfo("App returned to foreground")
                    Toaster.showToast(this@MainActivity, "App returned to foregroun")
                }
                AppStatus.BACKGROUND -> {
                    //App returned from background
                    Logger.debugLogInfo("App into background")
                }
                AppStatus.FOREGROUND -> {
                    //App returned from background
                    Logger.debugLogInfo("App is already on foreground")
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MainApplication).addAppStatusCallback(activityCallback)
        
        if (AppStorage(this).isFirstRun == true) {
            //Do some initial setup etc.
            Toaster.showToast(this, "Thank you for installing this app.")
            AppStorage(this).isFirstRun = false
        }
    }

    override fun onDestroy() {
        (application as MainApplication).removeAppStatusCallback(activityCallback)
        super.onDestroy()
    }
}