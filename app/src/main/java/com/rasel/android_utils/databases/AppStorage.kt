package com.rasel.android_utils.databases

import android.content.Context
import com.rasel.basicutils.storage.StoredMap

class AppStorage(context: Context): StoredMap(context) {
    var isFirstRun: Boolean? = true
}