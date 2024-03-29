package com.example.gridapptest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
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
                    color = MaterialTheme.colorScheme.surface
                ) {
                    GridApp(
                        modifier =Modifier.padding(0.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun GridApp(modifier: Modifier){
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier)
        {
            items(DataSource.topics){
                topic->
                SingleCell(Modifier,topic);
            }
        }
}

@Composable
fun SingleCell(modifier: Modifier=Modifier, thisTopic: Topic) {
    val mediumPadding=16.dp
    val smallPadding=8.dp
    Card {
        Box{
            Row {
                Image(painter = painterResource(id = thisTopic.imageOfTopic), contentDescription =stringResource(id = thisTopic.sTopicName),
                    modifier.size(68.dp,68.dp),contentScale = ContentScale.Crop)
                Column() {
                    Text(text = stringResource(id = thisTopic.sTopicName), modifier = modifier.padding(top=16.dp,start=mediumPadding, bottom = smallPadding),style = MaterialTheme.typography.bodyMedium)
                    Row (verticalAlignment = Alignment.CenterVertically){
                        Icon(
                            painter = painterResource(R.drawable.ic_grain),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = mediumPadding,
                                    top = 0.dp,
                                    end = 0.dp,
                                    bottom = 0.dp)
                        )
                        Text(text = thisTopic.numOfAssociates.toString(),style = MaterialTheme.typography.labelMedium, modifier=modifier.padding(
                            start = smallPadding,
                            top = 0.dp,
                            end = 0.dp,
                            bottom = 0.dp
                        ))
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun PreviewCard()
{
    SingleCell(thisTopic = DataSource.topics[0])
}
