package com.capitolgamesciencemedia.learning.uipractice

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capitolgamesciencemedia.learning.uipractice.ui.theme.UIPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            UIPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Input Unit") }
    var outputUnit by remember { mutableStateOf("Output Unit") }
    var inputUnitExpanded by remember { mutableStateOf(false) }
    var outputUnitExpanded by remember { mutableStateOf(false) }
    var inputUnitConversion by remember { mutableDoubleStateOf(0.0) }
    var outputUnitConversion by remember { mutableDoubleStateOf(0.0) }



    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Convert Units")
        Spacer(modifier = Modifier.height(height = 30.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
        })
        Spacer(modifier = Modifier.height(height = 25.dp))
        Row {
            Text(text = "Input Unit")
            Spacer(modifier = Modifier.width(width = 120.dp))
            Text(text = "Output Unit")
        }
        Spacer(modifier = Modifier.height(height = 10.dp))
        Row {
            Box {
                Button(onClick = { inputUnitExpanded = !inputUnitExpanded }) {
                    Text(text = inputUnit)
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
                DropdownMenu(expanded = inputUnitExpanded, onDismissRequest = { inputUnitExpanded = false }) {
                    DropdownMenuItem(text = {Text("Meter") }, onClick = {
                        inputUnit = "Meter"
                        inputUnitExpanded = !inputUnitExpanded
                        inputUnitConversion = 1.0
                    })
                    DropdownMenuItem(text = {Text("Centimeter") }, onClick = {
                        inputUnit = "Centimeter"
                        inputUnitExpanded = !inputUnitExpanded
                        inputUnitConversion = 0.01
                    })
                    DropdownMenuItem(text = {Text("Millimeter") }, onClick = {
                        inputUnit = "Millimeter"
                        inputUnitExpanded = !inputUnitExpanded
                        inputUnitConversion = 0.001
                    })
                    DropdownMenuItem(text = {Text("Kilometer") }, onClick = {
                        inputUnit = "Kilometer"
                        inputUnitExpanded = !inputUnitExpanded
                        inputUnitConversion = 1000.0
                    })
                }
            }
            Spacer(modifier = Modifier.width(width = 50.dp))
            Box {
                Button(onClick = { outputUnitExpanded = !outputUnitExpanded }) {
                    Text(text = outputUnit)
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
                DropdownMenu(expanded = outputUnitExpanded, onDismissRequest = { outputUnitExpanded = false }) {
                    DropdownMenuItem(text = {Text("Meter") }, onClick = {
                        outputUnit = "Meter"
                        outputUnitExpanded = !outputUnitExpanded
                        outputUnitConversion = 1.0
                    })
                    DropdownMenuItem(text = {Text("Centimeter") }, onClick = {
                        outputUnit = "Centimeter"
                        outputUnitExpanded = !outputUnitExpanded
                        outputUnitConversion = 0.01
                    })
                    DropdownMenuItem(text = {Text("Millimeter") }, onClick = {
                        outputUnit = "Millimeter"
                        outputUnitExpanded = !outputUnitExpanded
                        outputUnitConversion = 0.001
                    })
                    DropdownMenuItem(text = {Text("Kilometer") }, onClick = {
                        outputUnit = "Kilometer"
                        outputUnitExpanded = !outputUnitExpanded
                        outputUnitConversion = 1000.0
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(height = 20.dp))
        Button(onClick = {  outputValue = (inputValue.toDouble() * (inputUnitConversion / outputUnitConversion)).toString()}) {
            Text(text = "Convert")
        }
        Spacer(modifier = Modifier.height(height = 20.dp))
        Row {
            Text(text = "Result:")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = outputValue)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}

