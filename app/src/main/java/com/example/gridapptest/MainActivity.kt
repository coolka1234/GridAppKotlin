package com.example.gridapptest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridapptest.ui.theme.GridAppTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridAppTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}
@Composable
fun GridApp(){
    //SingleCell();
}

@Composable
fun SingleCell(modifier: Modifier=Modifier, thisTopic: Topic) {
    Card {
        Box{
            Row {
                Image(painter = painterResource(id = thisTopic.imageOfTopic), contentDescription =stringResource(id = thisTopic.sTopicName),
                    modifier.size(68.dp,68.dp))
                Column {
                    Text(text = stringResource(id = thisTopic.sTopicName), modifier = modifier.padding(16.dp))

                }
            }
        }
    }
}
@Composable
@Preview
fun previewCard()
{
    SingleCell(thisTopic = DataSource.topics[0]);
}
