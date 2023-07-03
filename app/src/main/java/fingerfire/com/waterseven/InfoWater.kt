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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text

val count = mutableStateOf(0f)

@Composable
fun InfoWater() {
    // Declaração do count

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
            text = "Você já bebeu ${count.value} litro de água hoje" // Resultado
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botões e lógica de incremento e decremento
            Button(
                onClick = { count.value += 0.5f },
                modifier = Modifier
                    .padding(end = 8.dp)
                    .height(40.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_water),
                    contentDescription = "Cup Water",
                    modifier = Modifier
                        .size(ButtonDefaults.DefaultButtonSize)
                        .wrapContentSize(align = Alignment.Center),
                )
            }
            Button(
                onClick = {
                    if (count.value >= 0.5f) {
                        count.value -= 0.5f
                    }
                },
                modifier = Modifier
                    .height(40.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_remove_water),
                    contentDescription = "Remove",
                    modifier = Modifier
                        .size(ButtonDefaults.DefaultButtonSize)
                        .wrapContentSize(align = Alignment.Center),
                )
            }
        }
        Box(
            modifier = Modifier.padding(top = 3.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { count.value = 0f },
                modifier = Modifier.size(30.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red, // Cor do fundo
                    contentColor = Color.White // Cor do texto
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_reset),
                    contentDescription = "Reset",
                )
            }
        }
    }
}
