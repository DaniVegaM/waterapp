package fingerfire.com.waterseven

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.CircularProgressIndicator

@Composable
fun ProgressIndicatorWater() {
    // Aqui você pode incluir a lógica do progresso e contagem da água

    // Box para centralizar
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            startAngle = 295f,
            endAngle = 245f,
            progress = 0.5f, // Exemplo de valor de progresso
            strokeWidth = 5.dp,
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp)
        )
        InfoWater() // Importação do novo Compose
    }
}
