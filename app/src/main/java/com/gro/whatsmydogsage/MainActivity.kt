package com.gro.whatsmydogsage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gro.whatsmydogsage.ui.theme.WhatsMyDogsAgeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsMyDogsAgeTheme {
                Screen()
            }
        }
    }
}

@Composable
fun Screen() {
    var inputNumber by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var size by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.AppName),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp, top = 100.dp),
        )
        Text(
            text = result,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.orange_500),
            fontSize = 60.sp,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(
                onClick = { size = 0 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (size == 0) Color.White else colorResource(id = R.color.green_400),
                    contentColor = Color.Black
                ),
                border = BorderStroke(0.5.dp, Color.Gray),
                modifier = Modifier.width(140.dp),
                shape = RectangleShape,
            ) {
                Text(text = stringResource(R.string.small))
            }
            Button(
                onClick = { size = 1 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (size == 1) Color.White else colorResource(id = R.color.green_400),
                    contentColor = Color.Black
                ),
                border = BorderStroke(0.5.dp, Color.Gray),
                modifier = Modifier.width(140.dp),
                shape = RectangleShape,
            ) {
                Text(text = stringResource(R.string.big))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = inputNumber,
            onValueChange = { inputNumber = it },
            Modifier.background(Color.White),
            label = { Text(stringResource(R.string.years)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                result = if (size == 0) {
                    smallSize(inputNumber.toInt())
                } else {
                    bigSize(inputNumber.toInt())
                }
            },
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.orange_500)),
            modifier = Modifier.width(280.dp),
            shape = RectangleShape,
        ) {
            Text(
                stringResource(R.string.calculate),
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

fun smallSize(years: Int): String {
    val firstTwoYears = 24.0
    if (years > 2) {
        val ageNumber = (((years - 2)) * 4.5) + firstTwoYears
        return ageNumber.toInt().toString()
    } else if (years == 2) {
        return firstTwoYears.toInt().toString()
    } else if (years == 1) {
        return "12"
    } else {
        return "0"
    }
}

fun bigSize(years: Int): String {
    val firstTwoYears = 18.0
    if (years > 2) {
        val ageNumber = (((years - 2)) * 8) + firstTwoYears
        return ageNumber.toInt().toString()
    } else if (years == 2) {
        return firstTwoYears.toInt().toString()
    } else if (years == 1) {
        return "9"
    } else {
        return "0"
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    WhatsMyDogsAgeTheme {
        Screen()
    }
}
