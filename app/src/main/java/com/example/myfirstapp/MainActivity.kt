package com.example.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstapp.ui.theme.MyFirstAppTheme

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import com.example.myfirstapp.R.drawable.kitty


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background, shape = RoundedCornerShape(8.dp)) {
                    TextBoxComposed(content = Article("My First Title", "JetPack Compose is a framework on which its components are composed"))
                }
            }
        }
    }
}

data class Article(val title: String, val body: String)

//You can use Row to arrange items horizontally and Box to stack elements.
@Composable
fun TextBoxComposed(content: Article){
    
    Row{
        Image( painter = painterResource(id = kitty),
                contentDescription = "kitty")
        Column{
            Text(text = content.title)
            Text(text = content.body)
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    MyFirstAppTheme {
        TextBoxComposed( content = Article( title ="Title Preview", body = "Body Preview"))
    }
}