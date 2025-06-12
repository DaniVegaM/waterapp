package fingerfire.com.waterseven

import android.content.Context
import android.content.SharedPreferences

object LocalStorageHelper {
    private const val PREFS_NAME = "water_prefs"
    private const val KEY_WATER_COUNT = "water_count"
    private const val KEY_SENSOR_HEART = "sensor_heart"
    private const val KEY_SENSOR_ACCEL = "sensor_accel"

    fun saveWaterCount(context: Context, count: Float) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putFloat(KEY_WATER_COUNT, count).apply()
    }

    fun loadWaterCount(context: Context): Float {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getFloat(KEY_WATER_COUNT, 0f)
    }

    fun saveSimulatedSensors(context: Context, heart: Int, accel: Float) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putInt(KEY_SENSOR_HEART, heart).putFloat(KEY_SENSOR_ACCEL, accel).apply()
    }

    fun loadSimulatedSensors(context: Context): Pair<Int, Float> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val heart = prefs.getInt(KEY_SENSOR_HEART, 70)
        val accel = prefs.getFloat(KEY_SENSOR_ACCEL, 0.0f)
        return Pair(heart, accel)
    }
}
