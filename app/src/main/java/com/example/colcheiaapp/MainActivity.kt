package com.example.colcheiaapp

import LoginScreen
import SignUpScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.example.colcheiaapp.ui.theme.ColcheiaappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColcheiaappTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable(
            "signup",
            deepLinks = listOf(navDeepLink { uriPattern = "android-app://androidx.navigation/signup" })
        ) { SignUpScreen(navController) }
        composable("home") { HomeScreen() }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ColcheiaappTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    ColcheiaappTheme {
        val navController = rememberNavController()
        SignUpScreen(navController)
    }
}
