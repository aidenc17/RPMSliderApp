package com.example.rpmsilderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rpmsilderapp.ui.theme.RPMSilderAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RPMSilderAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RPMSlider(
                        modifier = Modifier,

                    )
                }
            }
        }
    }
}

@Composable
fun RPMSliderApp(modifier: Modifier = Modifier) {
    // calls to RPMSlider and DialWithNeedle go here
}

@Composable
fun RPMSlider(
    /* parameters? */
    modifier: Modifier = Modifier
) {
    // the slider code will go here
}

@Composable
fun DialWithNeedle(
    /* parameters? */
    modifier: Modifier = Modifier) {
    // show the dial and needle in here
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RPMSilderAppTheme {
        RPMSliderApp(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
        )
    }
}