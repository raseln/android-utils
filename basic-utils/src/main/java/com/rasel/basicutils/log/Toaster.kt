package com.rasel.basicutils.log

import android.content.Context
import android.widget.Toast

object Toaster {

    private var toast: Toast? = null

    fun showToast(context: Context, message: String, length: Int = Toast.LENGTH_SHORT) {
        dismissExistingToast()
        toast = Toast.makeText(context, message, length)
        toast?.show()
    }

    private fun dismissExistingToast() {
        if (toast != null) {
            toast?.cancel()
        }
    }
}