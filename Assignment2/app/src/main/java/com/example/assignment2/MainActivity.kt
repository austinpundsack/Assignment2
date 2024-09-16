package com.example.assignment2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2.ui.theme.Assignment2Theme
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        val action = intent?.action
        if (action == "com.example.assignment2.ACTION_VIEW") {
            Log.d("MainActivity2", "New intent action received: $action")
            // Handle the new intent action
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        GreetingText(message = "Austin Pundsack", from = "1386283", modifier = Modifier.padding(8.dp))
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(onClick = {
                            val explicitIntent = Intent(this@MainActivity, MainActivity2::class.java)
                            startActivity(explicitIntent)
                        }) {
                            Text("Start Activity Explicitly")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            val implicitIntent = Intent("com.example.assignment2.ACTION_VIEW").apply {
                                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                            }
                            startActivity(implicitIntent)
                        }) {
                            Text("Start Activity Implicitly")
                        }



                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment2Theme {
        GreetingText(message = "Austin Pundsack", from = "1386283")
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center,modifier = modifier.padding(8.dp)) {
        Text(
            text = message,
            fontSize = 75.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}
