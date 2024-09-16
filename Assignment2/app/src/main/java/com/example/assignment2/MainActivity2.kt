package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                        Text(
                            text = "Mobile Software Engineering Challenges",
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        ChallengeList()
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            val mainIntent = Intent(this@MainActivity2, MainActivity::class.java)
                            startActivity(mainIntent)
                        }) {
                            Text("Main Activity")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ChallengeList() {
    val challenges = listOf(
        "1. Device Fragmentation",
        "2. OS Fragmentation",
        "3. Unstable and Dynamic Environment",
        "4. Rapid Changes",
        "5. Tool Support",
    )

    val bonusChallenges = listOf(
        "Bonus Challenges",
        "Low Tolerance",
        "Low Security and Privacy Awareness"
    )
    Column {
        challenges.forEach { challenge ->
            Text(
                text = challenge,
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        bonusChallenges.forEach { challenge ->
            val fontSize = if (challenge == "Bonus Challenges") 14.sp else 16.sp
            Text(
                text = challenge,
                fontSize = fontSize,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivity2Preview() {
    Assignment2Theme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Mobile Software Engineering Challenges",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            ChallengeList()
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {}) {
                Text("Main Activity")
            }
        }
    }
}
