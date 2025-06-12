package fingerfire.com.waterseven

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import kotlin.random.Random

val count = mutableStateOf(0f)

@Composable
fun InfoWater(notificationManager: WaterNotificationManager? = null) {
    val context = LocalContext.current
    var heartRate by remember { mutableStateOf(70) }
    var accel by remember { mutableStateOf(0.0f) }
    val countState = count

    // Cargar progreso guardado al iniciar
    if (countState.value == 0f) {
        countState.value = LocalStorageHelper.loadWaterCount(context)
        val (savedHeart, savedAccel) = LocalStorageHelper.loadSimulatedSensors(context)
        heartRate = savedHeart
        accel = savedAccel
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 30.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.primary,
            text = if (count.value == 1f) {
                "Ya has bebido ${count.value} litro de agua hoy"
            } else {
                "Ya has bebido ${count.value} litros de agua hoy"
            }
        )
        Text(
            modifier = Modifier.padding(vertical = 4.dp),
            text = "Ritmo cardíaco: $heartRate bpm"
        )
        Text(
            modifier = Modifier.padding(vertical = 4.dp),
            text = "Acelerómetro: $accel m/s²"
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botón para sumar agua
            Button(
                onClick = {
                    val previousAmount = countState.value
                    countState.value += 0.5f
                    LocalStorageHelper.saveWaterCount(context, countState.value)
                    LocalStorageHelper.saveSimulatedSensors(context, heartRate, accel)
                    notificationManager?.let { manager ->
                        if (manager.shouldShowNotification(previousAmount, countState.value)) {
                            manager.showAchievementNotification(countState.value)
                        }
                    }
                },
                modifier = Modifier.padding(end = 8.dp).height(40.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_water),
                    contentDescription = "Añadir Agua",
                    modifier = Modifier.size(ButtonDefaults.DefaultButtonSize).wrapContentSize(align = Alignment.Center),
                )
            }
            // Botón para restar agua
            Button(
                onClick = {
                    if (countState.value >= 0.5f) {
                        countState.value -= 0.5f
                        LocalStorageHelper.saveWaterCount(context, countState.value)
                        LocalStorageHelper.saveSimulatedSensors(context, heartRate, accel)
                    }
                },
                modifier = Modifier.height(40.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_remove_water),
                    contentDescription = "Quitar Agua",
                    modifier = Modifier.size(ButtonDefaults.DefaultButtonSize).wrapContentSize(align = Alignment.Center),
                )
            }
        }
        Box(
            modifier = Modifier.padding(top = 3.dp),
            contentAlignment = Alignment.Center
        ) {
            // Botón para reiniciar
            Button(
                onClick = {
                    countState.value = 0f
                    LocalStorageHelper.saveWaterCount(context, 0f)
                    // Simular nuevos valores de sensores
                    heartRate = Random.nextInt(60, 120)
                    accel = Random.nextFloat() * 10f
                    LocalStorageHelper.saveSimulatedSensors(context, heartRate, accel)
                },
                modifier = Modifier.size(30.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_reset),
                    contentDescription = "Reiniciar",
                )
            }
        }
        // Botón para simular sincronización local
        Button(
            onClick = {
                // Sincronización local (puedes mostrar un mensaje o cambiar valores)
                heartRate = Random.nextInt(60, 120)
                accel = Random.nextFloat() * 10f
                LocalStorageHelper.saveSimulatedSensors(context, heartRate, accel)
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Sincronizar con Android")
        }
    }
}
