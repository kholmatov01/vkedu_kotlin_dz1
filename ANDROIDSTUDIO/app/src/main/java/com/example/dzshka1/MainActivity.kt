package com.example.dzshka1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var blocks = 5
            Blocks()
        }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun AppContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(12f)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center,
        ) {
            Text (
                text = "Content",
                fontSize = 54.sp,
                color  = Color.Blue,
            )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Gray),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text (
                text = "Item1",
                modifier = Modifier.weight(1f),
                color  = Color.White,
                textAlign = TextAlign.Center
            )
            Text (
                text = "Item2",
                modifier = Modifier.weight(2f),
                color  = Color.White,
                textAlign = TextAlign.Center,
            )
            Text (
                text = "Item3",
                modifier = Modifier.weight(1f),
                color  = Color.White,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
private fun Blocks(
    modifier: Modifier = Modifier
) {
    var blocks by rememberSaveable {mutableStateOf(1)}
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .verticalScroll(
                rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween

    ){
        FlowRow(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            for (i in 1..blocks) {
                val color = if(i % 2 == 0) Color.Red else Color.Blue
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .padding(10.dp)
                        .background(color),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("$i", fontSize = 40.sp)
                }
            }
        }
        Box(
            modifier = modifier.fillMaxSize().padding(15.dp),
            contentAlignment = Alignment.Center,
        ) {
            Button(
                onClick = {
                    blocks++
                },
                modifier = Modifier.size(100.dp)
            ) {
                Text("+1", fontSize = 40.sp)
            }
        }
    }
}