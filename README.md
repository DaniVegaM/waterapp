<h1 align="center"> Water Seven </h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=30"><img alt="API" src="https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://kotlinlang.org"><img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-1.10.xx-blue"/></a>
  <img alt="MVVM" src="https://img.shields.io/badge/Jetpack Compose-Interface-orange"/>
</p>


<p align="center">
¡Monitorea tu consumo de agua! Desarrollada usando la librería Jetpack Compose para Android, esta app te permite controlar la cantidad de agua que bebes con solo unos toques en la pantalla de tu smartwatch.
</p>

## Autores / Authors
- **Daniel Vega Miranda**
- **Abraham Reyes Cuevas**

## Características / Features
- 💧 **Seguimiento de agua**: Registra tu consumo diario de agua
- 🔔 **Notificaciones push**: Recibe motivación cada 1.5 litros consumidos
- ⌚ **Optimizado para Wear OS**: Diseñado específicamente para smartwatches
- 🎯 **Interfaz intuitiva**: Botones simples para agregar, quitar y reiniciar
- 📊 **Progreso visual**: Indicador circular que muestra tu avance diario

## Tech stack & Open-source libraries
- Minimum SDK level 30
- [Kotlin](https://kotlinlang.org/)
- [JetPack Compose](https://developer.android.com/jetpack/compose)
- [Wear OS](https://developer.android.com/training/wearables)
- [Wear Tiles](https://developer.android.com/training/articles/wear-tiles)
- [Android Notifications](https://developer.android.com/develop/ui/views/notifications)

## Arquitectura del proyecto / Project Architecture
Modules Design:
- App
  - Ui.theme
    - Color
    - Shape
    - Theme
    - Type
   - InfoWater
   - ProgressIndicatorWater
   - WaterNotificationManager
   - NotificationPermissionHelper
   - WearApp
   - MainActivity
   - tile/
     - MainTileService
   - complication/
     - MainComplicationService

## Sistema de Notificaciones / Notification System
La app incluye un sistema inteligente de notificaciones que:
- Se activa cada 1.5 litros consumidos (1.5, 3.0, 4.5, 6.0, etc.)
- Muestra mensaje motivacional: "¡Vas bien, sigue así!"
- Incluye vibración personalizada
- Compatible con Android 13+ (manejo automático de permisos)

# License
```xml
Designed and developed by Daniel Vega Miranda & Abraham Reyes Cuevas - 2025

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

