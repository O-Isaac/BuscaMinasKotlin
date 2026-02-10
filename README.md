# 💣 BuscaMinas Kotlin

Una implementación moderna del clásico juego Buscaminas desarrollada en Kotlin con Jetpack Compose para Android.

<div align="center">
  <img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android">
  <img src="https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin">
  <img src="https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white" alt="Jetpack Compose">
</div>

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Capturas de Pantalla](#-capturas-de-pantalla)
- [Requisitos](#-requisitos)
- [Instalación](#-instalación)
- [Arquitectura](#-arquitectura)
- [Tecnologías](#-tecnologías)
- [Configuración del Juego](#-configuración-del-juego)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Desarrolladores](#-desarrolladores)
- [Licencia](#-licencia)

## ✨ Características

- 🎮 **Tres niveles de dificultad**: Baja, Media y Alta
- 🎨 **Interfaz moderna**: Diseñada con Jetpack Compose y Material Design 3
- 🔊 **Sistema de audio**: Configuración de sonido activable/desactivable
- 🌓 **Temas personalizables**: Modo claro, oscuro o automático según el sistema
- 🗺️ **Navegación fluida**: Implementada con Appyx Navigation
- 💾 **Gestión de partidas**: Sistema para guardar y borrar partidas
- 📱 **Responsive**: Adaptado a diferentes tamaños de pantalla

## 📸 Capturas de Pantalla

> *Pendiente de agregar capturas de pantalla*

## 📋 Requisitos

- **Android Studio**: Hedgehog (2023.1.1) o superior
- **Kotlin**: 2.0.21
- **Gradle**: 8.11.1
- **Android SDK**:
    - Min SDK: 24 (Android 7.0)
    - Target SDK: 35 (Android 15)
    - Compile SDK: 36

## 🚀 Instalación

### Clonar el repositorio

```bash
git clone https://github.com/yourusername/BuscaMinasKotlin.git
cd BuscaMinasKotlin
```

### Abrir en Android Studio

1. Abre Android Studio
2. Selecciona `File > Open`
3. Navega hasta la carpeta del proyecto y selecciónala
4. Espera a que Gradle sincronice las dependencias

### Ejecutar la aplicación

1. Conecta un dispositivo Android o inicia un emulador
2. Haz clic en el botón `Run` (▶️) o presiona `Shift + F10`

## 🏗️ Arquitectura

El proyecto sigue una arquitectura basada en componentes con separación de responsabilidades:

```
app/
├── components/          # Componentes UI reutilizables
│   ├── ajustes/        # Pantalla de configuración
│   ├── creditos/       # Pantalla de créditos
│   ├── menu/           # Menú principal
│   └── tablero/        # Tablero de juego
├── confg/              # Configuración del juego
├── models/             # Modelos de datos
├── navigation/         # Sistema de navegación
└── ui/theme/           # Tema y estilos
```

### Patrones utilizados

- **MVVM**: ViewModel para gestión de estado
- **Composable Components**: Componentes UI reutilizables
- **Navigation Component**: Appyx para navegación declarativa
- **State Management**: Uso de `mutableStateOf` y `derivedStateOf`

## 🛠️ Tecnologías

### Core

- **Kotlin** (2.0.21): Lenguaje de programación principal
- **Jetpack Compose**: Framework UI moderno y declarativo
- **Material Design 3**: Sistema de diseño de Google

### Librerías principales

```kotlin
// UI & Compose
androidx.compose.ui
androidx.compose.material3
androidx.lifecycle:lifecycle-viewmodel-compose

// Navigation
com.bumble.appyx:appyx-navigation (2.0.0)
com.bumble.appyx:backstack (2.0.0)

// Annotation Processing
com.google.devtools.ksp (2.0.21-1.0.28)
```

### Dependencias completas

Ver [libs.versions.toml](gradle/libs.versions.toml) para el catálogo completo de versiones.

## ⚙️ Configuración del Juego

### Niveles de Dificultad

El juego ofrece tres niveles de dificultad configurables:

| Nivel | Tamaño | Minas | Descripción |
|-------|--------|-------|-------------|
| **Baja** | 10×10 | 10 | Ideal para principiantes |
| **Media** | 15×15 | 20 | Dificultad equilibrada |
| **Alta** | 20×20 | 30 | Desafío para expertos |

### Personalización

La configuración del juego se gestiona mediante el patrón de objeto singleton:

```kotlin
// Cambiar dificultad
state.changeConfigManager(ConfigManagerAlta)
state.changeConfigManager(ConfigManagerMedia)
state.changeConfigManager(ConfigManagerBaja)
```

## 📁 Estructura del Proyecto

```
BuscaMinasKotlin/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/github/isaac/buscaminaskotlin/
│   │   │   │   ├── components/
│   │   │   │   │   ├── ajustes/
│   │   │   │   │   │   └── AjustesScreen.kt
│   │   │   │   │   ├── creditos/
│   │   │   │   │   │   └── CreditosScreen.kt
│   │   │   │   │   ├── menu/
│   │   │   │   │   │   ├── MenuButton.kt
│   │   │   │   │   │   └── MenuScreen.kt
│   │   │   │   │   └── tablero/
│   │   │   │   │       ├── Celda.kt
│   │   │   │   │       ├── TableroGrid.kt
│   │   │   │   │       ├── TableroScreen.kt
│   │   │   │   │       └── TableroTitulo.kt
│   │   │   │   ├── confg/
│   │   │   │   │   └── Config.kt
│   │   │   │   ├── models/
│   │   │   │   │   └── GameState.kt
│   │   │   │   ├── navigation/
│   │   │   │   │   └── root/
│   │   │   │   │       └── RootNode.kt
│   │   │   │   ├── ui/theme/
│   │   │   │   │   ├── Color.kt
│   │   │   │   │   ├── Theme.kt
│   │   │   │   │   └── Type.kt
│   │   │   │   └── MainActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── drawable/
│   │   │   │   ├── mipmap/
│   │   │   │   ├── values/
│   │   │   │   └── xml/
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   └── build.gradle.kts
│
├── gradle/
│   ├── libs.versions.toml
│   └── wrapper/
│
├── .gitignore
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── README.md
```

## 👥 Desarrolladores

Este proyecto ha sido desarrollado por:

- **Isaac Zaragoza Mendoza** - [@isaac](https://github.com/isaac)
- **Rubén Segura Pérez**
- **Roberto Martín Martín**
- **Miguel Díaz Velasco**

## 🤝 Contribuir

Las contribuciones son bienvenidas. Para cambios importantes:

1. Fork el proyecto
2. Crea una rama para tu característica (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📝 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 📧 Contacto

Para preguntas o sugerencias, puedes contactar a través de:

- GitHub Issues: [Crear un issue](https://github.com/yourusername/BuscaMinasKotlin/issues)

## 🙏 Agradecimientos

- Inspirado en el clásico juego Buscaminas de Microsoft
- Comunidad de Android Developers
- Equipo de Jetpack Compose

---

<div align="center">
  Hecho con ❤️ usando Kotlin y Jetpack Compose
</div>