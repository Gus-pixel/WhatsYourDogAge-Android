package com.gro.whatsmydogsage

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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
            TextField(
                value = inputNumber,
                onValueChange = { inputNumber = it },
                Modifier.background(Color.White),
                label = { Text(stringResource(R.string.years)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    fun setDogAge(){
                        result = (inputNumber.toInt() * 7).toString()
                    }
                    setDogAge()
                },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.orange_500)),
                modifier = Modifier.width(275.dp),
                shape = RoundedCornerShape(0),
            ) {
                Text("Calculate")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    WhatsMyDogsAgeTheme {
        Screen()
    }
}