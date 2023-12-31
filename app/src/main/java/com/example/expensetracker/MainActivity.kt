package com.example.expensetracker
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.pages.Add
import com.example.expensetracker.pages.Categories
import com.example.expensetracker.pages.Expenses
import com.example.expensetracker.pages.Reports
import com.example.expensetracker.pages.Settings
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme
import com.example.expensetracker.ui.theme.TopAppBarBackground
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContent {
            ExpenseTrackerTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()

                var showButtomBar by rememberSaveable { mutableStateOf(true) }

                // Mir Niyazul Haque

                showButtomBar= when (backStackEntry?.destination?.route){
                    "Settings/Categories"-> false
                    else ->true
                }
                Scaffold(
                    bottomBar = {
                        if(showButtomBar) {
                            NavigationBar(containerColor = TopAppBarBackground) {
                                NavigationBarItem(
                                    selected = backStackEntry?.destination?.route == "expenses",
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
                                    selected = backStackEntry?.destination?.route == "reports",
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
                                    selected = backStackEntry?.destination?.route == "add",
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
                                    selected = backStackEntry?.destination?.route?.startsWith("Settings")
                                        ?: false,
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
                                    Expenses(navController = navController )
                                }
                            }
                            composable("reports"){
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding)
                                ) {
                                   Reports()
                                }
                            }

                            composable("add"){
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding)
                                ) {
                                    Add( navController)
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
                                    Categories(navController = navController)
                                }
                            }
                        }
                    }


                )


            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExpenseTrackerTheme {
     
    }
}