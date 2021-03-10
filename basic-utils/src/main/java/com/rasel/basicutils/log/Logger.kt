package com.rasel.basicutils.log

import android.util.Log
import com.rasel.basicutils.BuildConfig

class Logger {

    companion object {
        private const val tag = BuildConfig.logTag

        private fun log(priority: Int, msg: String?, function: String? = null) {
            Log.println(priority, tag, "[$function] $msg")
        }

        // Using getStackTrace may cause a little time lag
        private inline val caller: String? get() = Throwable().stackTrace.let { if (it.size > 2) it[2].toString() else null }

        // Print log message for debug build only
        fun debugLogInfo(msg: Any?) = if (BuildConfig.DEBUG) logInfo(msg) else Unit
        internal fun debugLogError(msg: Any?) = if (BuildConfig.DEBUG) logError(msg) else Unit

        // Print log message
        private fun logInfo(msg: Any?) = log(Log.INFO, if (msg is String) msg else msg.toString(), caller)
        private fun logError(msg: Any?) = log(Log.ERROR, if (msg is String) msg else msg.toString(), caller)
    }

}