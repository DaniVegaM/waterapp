# Funcionalidad de Notificaciones Push - Water Seven

## Descripción
Se ha implementado un sistema de notificaciones push que se activa cada vez que el usuario alcanza múltiplos de 1.5 litros de agua consumida.

## Cómo Funciona

### Momentos de Notificación
Las notificaciones aparecen cuando se alcanzan estos hitos:
- 1.5 litros
- 3.0 litros  
- 4.5 litros
- 6.0 litros
- 7.5 litros
- Y así sucesivamente...

### Mensaje de Notificación
Cuando se alcanza un hito, aparece una notificación con:
- **Título**: "¡Vas bien, sigue así!"
- **Contenido**: "Has bebido X litros de agua hoy. ¡Excelente trabajo!"
- **Vibración**: Patrón personalizado de vibración
- **Icono**: Icono de agua de la app

## Componentes Implementados

### 1. WaterNotificationManager.kt
- Gestiona la creación y envío de notificaciones
- Crea el canal de notificación
- Verifica permisos antes de mostrar notificaciones
- Calcula cuándo mostrar notificaciones basado en hitos de 1.5L

### 2. NotificationPermissionHelper.kt
- Maneja los permisos de notificación para Android 13+
- Solicita permisos automáticamente cuando es necesario
- Verifica si ya se tienen los permisos requeridos

### 3. Modificaciones en MainActivity.kt
- Inicializa el gestor de notificaciones
- Solicita permisos de notificación al iniciar la app

### 4. Modificaciones en InfoWater.kt
- Integra la lógica de notificaciones con el botón de agregar agua
- Verifica si se debe mostrar notificación después de cada incremento

## Permisos Añadidos
```xml
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
<uses-permission android:name="android.permission.VIBRATE" />
```

## Flujo de Funcionamiento

1. **Usuario abre la app**: Se solicitan permisos de notificación si es necesario
2. **Usuario presiona el botón de agua**: Se incrementa en 0.5L el contador
3. **Sistema verifica hitos**: Comprueba si se alcanzó un múltiplo de 1.5L
4. **Muestra notificación**: Si se alcanzó un hito, muestra la notificación de logro
5. **Usuario ve el mensaje**: Recibe motivación para continuar hidratándose

## Características Técnicas

- **Compatible con Android 13+**: Maneja automáticamente los nuevos permisos de notificación
- **Optimizado para Wear OS**: Notificaciones diseñadas específicamente para smartwatches
- **Vibración inteligente**: Patrón de vibración que no molesta pero es notable
- **Gestión de errores**: Maneja casos donde no se tienen permisos sin crashear la app

## Instalación y Uso

1. Instala la app en tu smartwatch Wear OS
2. Al abrirla por primera vez, acepta los permisos de notificación
3. Comienza a trackear tu consumo de agua usando el botón +
4. ¡Recibe notificaciones motivacionales cada 1.5L consumidos!

---

La implementación es completamente automática y no requiere configuración adicional del usuario.
