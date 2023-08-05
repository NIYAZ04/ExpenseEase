package com.example.expensetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.pages.Expenses
import com.example.expensetracker.pages.Settings
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
              val navController = rememberNavController()
                val backStackEntry= navController.currentBackStackEntryAsState()


                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route =="expenses",
                                onClick = { navController.navigate("expenses") },
                                label = {
                                    Text("Expenses")
                                },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.upload),
                                        contentDescription = "Upload"
                                    )
                                },

                                )
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route =="reports",
                                onClick = { navController.navigate("reports") },
                                label = {
                                    Text("Chart")
                                },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.bar_chart),
                                        contentDescription = "Barchart"
                                    )
                                },

                                )
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route =="add",
                                onClick = { navController.navigate("add") },
                                label = {
                                    Text("Add")
                                },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.add),
                                        contentDescription = "add"
                                    )
                                },

                                )
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route =="Settings",
                                onClick = { navController.navigate("Settings") },
                                label = {
                                    Text("Setting")
                                },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.setting_outlined),
                                        contentDescription = "Settings"
                                    )
                                },

                                )

                        }


                    },
                    content = { innerPadding ->
                        
                        NavHost(navController = navController,
                            startDestination = "expenses"
                        ){

                            composable("expenses"){
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding)
                                ) {
                             Expenses(navController = navController, name ="expenses" )
                                }
                            }
                            composable("reports"){
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding)
                                ) {
                                    Greeting(name = "reports")
                                }
                            }

                            composable("add"){
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding)
                                ) {
                                    Greeting(name = "add")
                                }
                            }

                            composable("Settings"){
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding)
                                ) {
                                    Settings(navController = navController)
                                }
                            }
                            composable("Settings/Categories"){
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding)
                                ) {
                                    Greeting(name = "Categories")
                                }
                            }
                        }
                    } 
                       
                    
                )


            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExpenseTrackerTheme {
        Greeting("Android")
    }
}