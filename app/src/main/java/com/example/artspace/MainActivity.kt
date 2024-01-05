package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var step by remember {
        mutableStateOf(1)
    }

    val painterId = painterRes(step)
    val nameId = nameRes(step)
    val authorId = authorRes(step)
    val yearId = yearRes(step)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
    ) {
        ImageSpace(
            painter = painterId,
            contentDescription = nameId
        )
        DescriptionSpace(
            imageName = nameId,
            imageAuthor = authorId,
            imageYear = yearId
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 5.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth(0.5f)) {
                Button(
                    onClick = { if (step > 1) step-- else step = 10 },
                    border = BorderStroke(1.dp, Color.LightGray),
                    shape = RectangleShape,
                    modifier = Modifier
                        .padding(2.dp, 0.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Previous")
                }
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { if (step < 10) step++ else step = 1 },
                    border = BorderStroke(1.dp, Color.LightGray),
                    shape = RectangleShape,
                    modifier = Modifier
                        .padding(2.dp, 0.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Composable
private fun ImageSpace(
    @DrawableRes painter: Int,
    @StringRes contentDescription: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(20.dp, 10.dp)
            .fillMaxWidth()
            .background(color = Color(0f, 0f, 0f, 0.05f)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(0.dp, 5.dp)
                .background(color = Color.White)
                .border(width = 1.dp, color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(painter),
                contentDescription = stringResource(contentDescription),
                modifier = Modifier.padding(5.dp, 10.dp)
            )
        }
    }
}

@Composable
private fun DescriptionSpace(
    @StringRes imageName: Int,
    @StringRes imageAuthor: Int,
    @StringRes imageYear: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(color = Color(0f, 0f, 0f, 0.05f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text(
                text = stringResource(imageName),
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.padding(0.dp, 2.dp))
            Row {
                Text(
                    text = stringResource(imageAuthor),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = "(${stringResource(imageYear)})",
                    fontSize = 14.sp
                )
            }
        }
    }
}

private fun painterRes(step: Int): Int {
    return when(step) {
        1 -> R.drawable.foto_en_escala_de_grises_de_cabello_negro_de_mujer_stephany_lorena_2018
        2 -> R.drawable.callejon_de_la_pared_de_graffiti_durante_el_diajames_garman_2018
        3 -> R.drawable.pintura_de_gato_negro_alena_k_2019
        4 -> R.drawable.una_puerta_cubierta_de_graffiti_y_pegatinas_paolo_nicolello_2018
        5 -> R.drawable.fotografia_de_arbol_fabrice_villard_2018
        6 -> R.drawable.plantas_de_hojas_verde_dentro_del_edificio_felix_dubois_robert_2016
        7 -> R.drawable.pintura_abstracta_azul_amarilla_y_roja_alexander_ant_2021
        8 -> R.drawable.mujer_de_pelo_negro_pintado_en_la_pared_raghav_modi_2019
        9 -> R.drawable.mujer_en_vestido_negro_montando_en_bicicleta_roja_yaopey_yong_2020
        else -> R.drawable.pajaro_marron_y_negro_sobre_planta_verde_boston_public_library_2020
    }
}

private fun nameRes(step: Int): Int {
    return when(step) {
        1 -> R.string.art_image_name_1
        2 -> R.string.art_image_name_2
        3 -> R.string.art_image_name_3
        4 -> R.string.art_image_name_4
        5 -> R.string.art_image_name_5
        6 -> R.string.art_image_name_6
        7 -> R.string.art_image_name_7
        8 -> R.string.art_image_name_8
        9 -> R.string.art_image_name_9
        else -> R.string.art_image_name_10
    }
}

private fun authorRes(step: Int): Int {
    return when(step) {
        1 -> R.string.art_image_author_1
        2 -> R.string.art_image_author_2
        3 -> R.string.art_image_author_3
        4 -> R.string.art_image_author_4
        5 -> R.string.art_image_author_5
        6 -> R.string.art_image_author_6
        7 -> R.string.art_image_author_7
        8 -> R.string.art_image_author_8
        9 -> R.string.art_image_author_9
        else -> R.string.art_image_author_10
    }
}

private fun yearRes(step: Int): Int {
    return when(step) {
        1 -> R.string.art_image_year_1
        2 -> R.string.art_image_year_2
        3 -> R.string.art_image_year_3
        4 -> R.string.art_image_year_4
        5 -> R.string.art_image_year_5
        6 -> R.string.art_image_year_6
        7 -> R.string.art_image_year_7
        8 -> R.string.art_image_year_8
        9 -> R.string.art_image_year_9
        else -> R.string.art_image_year_10
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}