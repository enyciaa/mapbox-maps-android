package com.mapbox.maps

import android.os.Looper
import android.util.Log
import com.mapbox.common.MapboxSDKCommon

internal class ThreadChecker {

  // Captures if the customer application is running in debug
  private val debug: Boolean

  init {
    val packageName = MapboxSDKCommon.getContext().applicationInfo.packageName
    val buildConfigClass = Class.forName("$packageName.BuildConfig")
    debug = buildConfigClass.getField("DEBUG").getBoolean(null)
  }

  fun isMainThread(): Boolean {
    val startTime = System.nanoTime()
    if (debug && Thread.currentThread() != Looper.getMainLooper().thread) {
      return false
    }
    val diff = System.nanoTime() - startTime
    Log.e("TVN", "Main thread checking took: $diff nano")
    return true
  }
}