package com.github.isaac.buscaminaskotlin.components.ajustes

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.isaac.buscaminaskotlin.R
import com.github.isaac.buscaminaskotlin.components.menu.MenuButton

data class Dificultad(val nombre: String, val descripcion: String, val minas: Int)
data class Apariencia(val nombre: String, val descripcion: String)

@Composable
fun SeccionTitulo(
    texto: String,
    icono: androidx.compose.ui.graphics.vector.ImageVector,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        color = Color(0x33000000), // Fondo negro semitransparente
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, Color(0xFFFFD54F))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icono,
                contentDescription = texto,
                tint = Color(0xFFFFD54F),
                modifier = Modifier
                    .size(28.dp)
                    .padding(end = 4.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = texto.uppercase(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFFFD54F),
                letterSpacing = 1.5.sp
            )
        }
    }
}

@Composable
fun AjustesScreen() {
    // Estados
    var dificultadExpandida by remember { mutableStateOf(false) }
    var dificultadSeleccionada by remember {
        mutableStateOf(Dificultad("Media", "20 minas", 20))
    }
    var sonidoActivado by remember { mutableStateOf(true) }
    var aparienciaExpandida by remember { mutableStateOf(false) }
    var aparienciaSeleccionada by remember {
        mutableStateOf(Apariencia("Del sistema", "Automático según el sistema"))
    }
    var mostrarDialogoBorrar by remember { mutableStateOf(false) }

    val dificultades = listOf(
        Dificultad("Alta", "30 minas", 30),
        Dificultad("Media", "20 minas", 20),
        Dificultad("Baja", "10 minas", 10)
    )

    val apariencias = listOf(
        Apariencia("Del sistema", "Automático según el sistema"),
        Apariencia("Modo claro", "Tema claro siempre"),
        Apariencia("Modo oscuro", "Tema oscuro siempre")
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Fondo
        Image(
            painter = painterResource(R.drawable.fondo2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 0.dp)
                    .padding(bottom = 24.dp, top = 48.dp),
                color = Color(0x33000000), // Fondo negro semitransparente
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Color(0xFFFFD54F))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "AJUSTES",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFFFD54F),
                        fontSize = 48.sp,
                        letterSpacing = 1.5.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Sección Dificultad
            SeccionTitulo(
                texto = "Dificultad",
                icono = Icons.Filled.Settings
            )

            // Botón de dificultad con dropdown
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                // Sombra del botón
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .offset(y = 6.dp)
                        .background(
                            color = Color(0xFF8B7000),
                            shape = RoundedCornerShape(16.dp)
                        )
                )

                // Botón principal
                Button(
                    onClick = { dificultadExpandida = !dificultadExpandida },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFD54F),
                        contentColor = Color(0xFF2C2C2C)
                    ),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(4.dp, Color(0xFFFFF9C4)),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 6.dp,
                        pressedElevation = 2.dp
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = dificultadSeleccionada.nombre,
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF2C2C2C)
                            )
                            Text(
                                text = dificultadSeleccionada.descripcion,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xFF4E4E4E)
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir",
                            tint = Color(0xFF2C2C2C),
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }

                // Dropdown Menu
                MaterialTheme(
                    shapes = MaterialTheme.shapes.copy(
                        extraSmall = RoundedCornerShape(16.dp)
                    )
                ) {
                    DropdownMenu(
                        expanded = dificultadExpandida,
                        onDismissRequest = { dificultadExpandida = false },
                        modifier = Modifier
                            .width(IntrinsicSize.Max)
                            .widthIn(min = 300.dp)
                            .background(
                                color = Color(0xFFFFD54F),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .padding(4.dp),
                        offset = androidx.compose.ui.unit.DpOffset(0.dp, 8.dp),
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(4.dp, Color(0xFFFFF9C4)),
                        shadowElevation = 8.dp
                    ) {
                        // Sombra interna simulada con Box
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color(0xFFFFD54F),
                                    shape = RoundedCornerShape(12.dp)
                                )
                        ) {
                            Column {
                                dificultades.forEach { dificultad ->
                                    DropdownMenuItem(
                                        text = {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(vertical = 8.dp, horizontal = 8.dp)
                                            ) {
                                                Text(
                                                    text = dificultad.nombre,
                                                    style = MaterialTheme.typography.titleMedium,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(0xFF2C2C2C)
                                                )
                                                Text(
                                                    text = dificultad.descripcion,
                                                    style = MaterialTheme.typography.bodyMedium,
                                                    color = Color(0xFF4E4E4E)
                                                )
                                            }
                                        },
                                        onClick = {
                                            dificultadSeleccionada = dificultad
                                            dificultadExpandida = false
                                            Log.d("AjustesScreen", "Dificultad seleccionada: ${dificultad.nombre}")
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(
                                                if (dificultad == dificultadSeleccionada)
                                                    Color(0xFFFFE082)
                                                else Color.Transparent
                                            ),
                                        colors = MenuDefaults.itemColors(
                                            textColor = Color(0xFF2C2C2C)
                                        )
                                    )
                                    if (dificultad != dificultades.last()) {
                                        HorizontalDivider(
                                            color = Color(0xFF8B7000),
                                            thickness = 2.dp,
                                            modifier = Modifier.padding(horizontal = 8.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Sección Sonido
            SeccionTitulo(
                texto = "Audio",
                icono = Icons.Filled.Settings
            )

            // Botón de sonido con switch
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                // Sombra del botón
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .offset(y = 6.dp)
                        .background(
                            color = Color(0xFF8B7000),
                            shape = RoundedCornerShape(16.dp)
                        )
                )

                // Botón principal con switch
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    color = Color(0xFFFFD54F),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(4.dp, Color(0xFFFFF9C4)),
                    shadowElevation = 6.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (sonidoActivado) "Activado" else "Desactivado",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2C2C2C)
                        )
                        Switch(
                            checked = sonidoActivado,
                            onCheckedChange = {
                                sonidoActivado = it
                                Log.d("AjustesScreen", "Sonido: ${if (it) "Activado" else "Desactivado"}")
                            },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color(0xFF4CAF50),
                                checkedTrackColor = Color(0xFF81C784),
                                uncheckedThumbColor = Color(0xFF9E9E9E),
                                uncheckedTrackColor = Color(0xFFBDBDBD),
                                checkedBorderColor = Color(0xFF2E7D32),
                                uncheckedBorderColor = Color(0xFF757575)
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Sección Apariencia
            SeccionTitulo(
                texto = "Tema Visual",
                icono = Icons.Filled.Info
            )

            // Botón de apariencia con dropdown
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                // Sombra del botón
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .offset(y = 6.dp)
                        .background(
                            color = Color(0xFF8B7000),
                            shape = RoundedCornerShape(16.dp)
                        )
                )

                // Botón principal
                Button(
                    onClick = { aparienciaExpandida = !aparienciaExpandida },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFD54F),
                        contentColor = Color(0xFF2C2C2C)
                    ),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(4.dp, Color(0xFFFFF9C4)),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 6.dp,
                        pressedElevation = 2.dp
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = aparienciaSeleccionada.nombre,
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF2C2C2C)
                            )
                            Text(
                                text = aparienciaSeleccionada.descripcion,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xFF4E4E4E)
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir",
                            tint = Color(0xFF2C2C2C),
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }

                // Dropdown Menu
                MaterialTheme(
                    shapes = MaterialTheme.shapes.copy(
                        extraSmall = RoundedCornerShape(16.dp)
                    )
                ) {
                    DropdownMenu(
                        expanded = aparienciaExpandida,
                        onDismissRequest = { aparienciaExpandida = false },
                        modifier = Modifier
                            .width(IntrinsicSize.Max)
                            .widthIn(min = 300.dp)
                            .background(
                                color = Color(0xFFFFD54F),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .padding(4.dp),
                        offset = androidx.compose.ui.unit.DpOffset(0.dp, 8.dp),
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(4.dp, Color(0xFFFFF9C4)),
                        shadowElevation = 8.dp
                    ) {
                        // Sombra interna simulada con Box
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color(0xFFFFD54F),
                                    shape = RoundedCornerShape(12.dp)
                                )
                        ) {
                            Column {
                                apariencias.forEach { apariencia ->
                                    DropdownMenuItem(
                                        text = {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(vertical = 8.dp, horizontal = 8.dp)
                                            ) {
                                                Text(
                                                    text = apariencia.nombre,
                                                    style = MaterialTheme.typography.titleMedium,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(0xFF2C2C2C)
                                                )
                                                Text(
                                                    text = apariencia.descripcion,
                                                    style = MaterialTheme.typography.bodyMedium,
                                                    color = Color(0xFF4E4E4E)
                                                )
                                            }
                                        },
                                        onClick = {
                                            aparienciaSeleccionada = apariencia
                                            aparienciaExpandida = false
                                            Log.d("AjustesScreen", "Apariencia seleccionada: ${apariencia.nombre}")
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(
                                                if (apariencia == aparienciaSeleccionada)
                                                    Color(0xFFFFE082)
                                                else Color.Transparent
                                            ),
                                        colors = MenuDefaults.itemColors(
                                            textColor = Color(0xFF2C2C2C)
                                        )
                                    )
                                    if (apariencia != apariencias.last()) {
                                        HorizontalDivider(
                                            color = Color(0xFF8B7000),
                                            thickness = 2.dp,
                                            modifier = Modifier.padding(horizontal = 8.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Sección Borrar Partidas
            SeccionTitulo(
                texto = "Gestión de Datos",
                icono = Icons.Filled.Warning
            )

            // Botón para borrar partidas
            MenuButton(
                texto = "Borrar partidas existentes",
                onClick = {
                    mostrarDialogoBorrar = true
                    Log.d("AjustesScreen", "Solicitud de borrar partidas")
                }
            )

            // Diálogo de confirmación
            if (mostrarDialogoBorrar) {
                AlertDialog(
                    onDismissRequest = { mostrarDialogoBorrar = false },
                    title = {
                        Text(
                            text = "¿Estás seguro?",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2C2C2C)
                        )
                    },
                    text = {
                        Text(
                            text = "Se eliminarán todas las partidas guardadas. Esta acción no se puede deshacer.",
                            color = Color(0xFF4E4E4E)
                        )
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                // Aquí iría la lógica para borrar partidas
                                Log.d("AjustesScreen", "Partidas borradas")
                                mostrarDialogoBorrar = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFD32F2F),
                                contentColor = Color.White
                            )
                        ) {
                            Text("Sí, borrar")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { mostrarDialogoBorrar = false },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF757575),
                                contentColor = Color.White
                            )
                        ) {
                            Text("No, cancelar")
                        }
                    },
                    containerColor = Color(0xFFFFD54F),
                    shape = RoundedCornerShape(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            // Botón para volver (opcional)
            MenuButton(
                texto = "Volver al Menú",
                onClick = { Log.d("AjustesScreen", "Volver al menú clicked") }
            )
        }
    }
}

@Preview(showBackground = true, locale = "es")
@Composable
fun AjustesScreenPreview() {
    AjustesScreen()
}
