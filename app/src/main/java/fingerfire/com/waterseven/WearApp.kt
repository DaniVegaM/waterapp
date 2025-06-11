package fingerfire.com.waterseven

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.TimeText
import fingerfire.com.waterseven.theme.WaterSevenOSTheme

@Composable
fun WearApp(notificationManager: WaterNotificationManager? = null) {
    WaterSevenOSTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            timeText = {
                TimeText()
            },
        ) {
            ProgressIndicatorWater(notificationManager)
        }
    }
}
