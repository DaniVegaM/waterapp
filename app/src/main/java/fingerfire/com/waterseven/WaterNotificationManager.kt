package fingerfire.com.waterseven

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class WaterNotificationManager(private val context: Context) {
    
    companion object {
        private const val CHANNEL_ID = "water_achievement_channel"
        private const val NOTIFICATION_ID = 1001
    }
    
    init {
        createNotificationChannel()
    }
    
    private fun createNotificationChannel() {
        val name = "Logros de Agua"
        val descriptionText = "Notificaciones cuando alcanzas metas de consumo de agua"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
            description = descriptionText
            enableVibration(true)
        }
        
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
    
    fun showAchievementNotification(litersConsumed: Float) {
        // Verificar si tenemos permisos para enviar notificaciones
        if (context is android.app.Activity && 
            !NotificationPermissionHelper.hasNotificationPermission(context)) {
            return
        }
        
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_water)
            .setContentTitle("¡Vas bien, sigue así!")
            .setContentText(
                if (litersConsumed == 1f) {
                    "Has bebido ${litersConsumed} litro de agua hoy. ¡Excelente trabajo!"
                } else {
                    "Has bebido ${litersConsumed} litros de agua hoy. ¡Excelente trabajo!"
                }
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(0, 250, 250, 250))
            .build()
        
        try {
            with(NotificationManagerCompat.from(context)) {
                notify(NOTIFICATION_ID, notification)
            }
        } catch (e: SecurityException) {
            // Manejar el caso donde no se otorgaron permisos de notificación
            e.printStackTrace()
        }
    }
    
    fun shouldShowNotification(previousAmount: Float, newAmount: Float): Boolean {
        // Verificar si hemos cruzado un hito de 1.5 litros
        val previousMilestone = (previousAmount / 1.5f).toInt()
        val currentMilestone = (newAmount / 1.5f).toInt()
        
        return currentMilestone > previousMilestone && newAmount >= 1.5f
    }
}
