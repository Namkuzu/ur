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
import com.namkuzo.ur.screen.MiscScreen
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
                    onPageSelected = { page ->
                        navController.navigate(page)
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
            composable(miscScreen){
                MiscScreen(
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}

const val buttonsScreen = "Buttons"
const val dialogsScreen = "Dialogs"
const val spinnerScreen = "Spinner"
const val miscScreen = "Misc"
const val menuScreen = "Menu"