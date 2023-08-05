package com.example.expensetracker.pages


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.expensetracker.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Expenses(navController: NavController, name : String){
    Scaffold (
        topBar = {
            MediumTopAppBar(title = {Text( "Expenses")},
                colors = TopAppBarDefaults
                .mediumTopAppBarColors(containerColor = TopAppBarBackground))
        },
        content = {innerPadding->
            Column(modifier=Modifier.padding(innerPadding)) {
                Text("Hello, Expenses")
            }
        }
    )


}



@Preview
@Composable
fun ExpensePreview(){

}