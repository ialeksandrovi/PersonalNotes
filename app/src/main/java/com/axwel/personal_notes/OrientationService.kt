package com.axwel.personal_notes

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.content.Context.WINDOW_SERVICE
import android.content.res.Configuration
import android.hardware.SensorManager
import android.view.WindowManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService


class OrientationService(private val context: Context) {
    fun isLandscape() = context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}