package com.example.expensetracker.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.expensetracker.ui.theme.TopAppBarBackground

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.expensetracker.components.TableRow

import com.example.expensetracker.ui.theme.BackgroundElevated
import com.example.expensetracker.ui.theme.DividerColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController: NavController){
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text("Settings") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground
                )
            )
        },
        content = {innerPadding->
            Column(modifier= Modifier.padding(innerPadding))
            {
                Column ( modifier= Modifier
                    .padding(horizontal = 16.dp)
                    .clip(shapes.large)
                    .fillMaxWidth()
                    .background(BackgroundElevated)
                )
                {
                    TableRow(label="Categories",hasArrow = true, modifier = Modifier.clickable
                    {

                        navController.navigate("Settings/Categories")
                    }
                    )
                    Divider(
                        modifier = Modifier
                            .padding(start = 1.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow(label="Erase Data", isDestructive = true)
                }
            }
        }
    )
}
