package com.example.expensetracker.pages

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontVariation
import com.example.expensetracker.ui.theme.TopAppBarBackground

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.expensetracker.Components.TableRow

import com.example.expensetracker.ui.theme.BackgroundElevated
import com.example.expensetracker.ui.theme.TopAppBarBackground
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController: NavController){
    Scaffold (
        topBar = {
            MediumTopAppBar(title = { Text( "Settings") }, colors = TopAppBarDefaults
                .mediumTopAppBarColors(containerColor = TopAppBarBackground))
        },
        content = {innerPadding->
            Column(modifier= Modifier.padding(innerPadding)) {
                Column ( modifier=Modifier
                    .padding(16.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .fillMaxWidth()
                    .background(BackgroundElevated)
                ){
                    TableRow("Categories",hasArrow = true)
                    TableRow("Erase all Data", isDestructive = true)
                }
            }
        }
    )
}
