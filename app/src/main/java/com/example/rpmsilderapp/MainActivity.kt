package com.example.rpmsilderapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
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
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    // calls to RPMSlider and DialWithNeedle go here
Column(modifier = Modifier) {
    DialWithNeedle(sliderPosition)

    //state hoisting
    RPMSlider(sliderPosition, { sliderPosition = it })
}

}

@Composable
fun RPMSlider(
    /* parameters? */
    sliderPosition: Float,
    onSliderChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {

        Column(modifier = modifier){
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 0f..1f,
            )
            Text(text = sliderPosition.toString())
        }

    // the slider code will go here

}

@Composable
fun DialWithNeedle(
    /* parameters? */
    sliderPosition: Float,
    modifier: Modifier = Modifier) {

    // show the dial and needle in here
    Box(modifier = Modifier){
        Image(painter = painterResource(id = R.drawable.iu),
            contentDescription = "Dial")
        Image(painter = painterResource(id = R.drawable.rpmneedle),
            contentDescription = "Needle",

            //linear interpolation
            modifier = Modifier.rotate(sliderPosition * 270f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RPM_Preview() {
    RPMSilderAppTheme {
        RPMSliderApp(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
        )
    }
}