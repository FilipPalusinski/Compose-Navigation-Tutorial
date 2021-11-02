package pl.studioandroida.composenavigationtutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pl.studioandroida.composenavigationtutorial.ui.theme.ComposeNavigationTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTutorialTheme {
                Navigation()
            }
        }
    }


}


@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate(Screen.DetailScreen.withArgs(text))
        },
        modifier = Modifier.align(Alignment.End)
        ) {
            Text("To DetailScreen")
        }
    }
}

@Composable
fun DetailScreen(name: String?) {
    Box(contentAlignment = Alignment.Center,modifier = Modifier.fillMaxSize()){
        Text(text = "Hello $name")
    }
}

