package com.namkuzo.ur

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.namkuzo.ur.screen.ButtonScreen
import com.namkuzo.ur.screen.DialogsScreen
import com.namkuzo.ur.screen.MenuScreen
import com.namkuzo.ur.screen.SpinnerScreen

@Composable
fun MainApp(){
    val navController = rememberNavController()
    Scaffold {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = menuScreen
        ){
            composable(menuScreen){
                MenuScreen(
                    onPageSelected = {
                        navController.navigate(it)
                    }
                )
            }
            composable(buttonsScreen){
                ButtonScreen(
                    onBack = { navController.popBackStack() }
                )
            }
            composable(dialogsScreen){
                DialogsScreen(
                    onBack = { navController.popBackStack() }
                )
            }
            composable(spinnerScreen){
                SpinnerScreen(
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}

val buttonsScreen = "Buttons"
val dialogsScreen = "Dialogs"
val spinnerScreen = "Spinner"
val menuScreen = "Menu"