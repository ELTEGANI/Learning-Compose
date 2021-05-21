package com.atechytask.learningcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp{
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(content:@Composable () -> Unit){
    BasicsCodelabTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = List(1000){"Android $it"}) {
    val counterState = remember { mutableStateOf(0)}
    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(names, Modifier.weight(1f))
        Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }

@Composable
fun Greetings(name:String){
      var isSelected by remember { mutableStateOf(false)}
      val backgroundColor by animateColorAsState(if(isSelected)
          Color.Red else Color.Transparent)
      Text(text ="Hello $name!",modifier = Modifier.padding(24.dp)
          .background(color = backgroundColor)
          .clickable(onClick = {isSelected = !isSelected})
      )
}
        Spacer(modifier = Modifier.height(18.dp))

        Text(text = "a day in shark live,a day in shark livea day in shark livea day in shark livea day in shark livea day in shark livea day in shark live",style = typography.h6,
        maxLines = 2,overflow = TextOverflow.Ellipsis)
        Text(text = "Davenport",style = typography.body1)
        Text(text = "December 12",style = typography.body2)

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MyApp {
        MyScreenContent()
    }
}

@Composable
fun Counter(count:Int,updateCount:(Int)->Unit) {
    Button(onClick = { updateCount(count+1) },
            colors = ButtonDefaults.buttonColors(
            backgroundColor = if(count > 5) Color.Green else Color.White
            )
    ) {
        Text("I've been clicked $count times")
    }
}

@Composable
fun NameList(names:List<String>,modifier: Modifier = Modifier){
  LazyColumn(modifier = modifier) {
      items (items = names){name->
           Greetings(name = name)
           Divider(color = Color.Black)
      }
  }
}