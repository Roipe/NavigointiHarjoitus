package com.example.navigointiharjoitus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigointiharjoitus.ui.theme.NavigointiHarjoitusTheme
import com.example.navigointiharjoitus.view.ScreenA
import com.example.navigointiharjoitus.view.ScreenB
import com.example.navigointiharjoitus.view.ScreenC
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigointiHarjoitusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Navigation(navController)
                }

            }
        }
    }
}
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "screenA") {
        composable(route = "screenA") {
            ScreenA(
                goToScreenB = { navController.navigate("screenB") },
                goToScreenC = { navController.navigate("screenC") }
            )
        }
        composable(route = "screenB") {
            ScreenB(goToScreenA = { navController.navigate("screenA")})
        }
        composable(route = "screenC") {
            ScreenC(goToScreenA = { navController.navigate("screenA")})
        }
    }
 }

