package com.example.expensetracker.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.expensetracker.Components.TableRow
import com.example.expensetracker.Components.UnstyledTextField
import com.example.expensetracker.ui.theme.BackgroundElevated
import com.example.expensetracker.ui.theme.DividerColor
import com.example.expensetracker.ui.theme.TopAppBarBackground


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Add(navController:NavController){
    Scaffold (
        topBar = {
            MediumTopAppBar(title = { Text( "Add") }, colors = TopAppBarDefaults
                .mediumTopAppBarColors(containerColor = TopAppBarBackground))
        },
        content = {innerPadding->
            Column(modifier= Modifier.padding(innerPadding)) {
                Column ( modifier= Modifier
                    .padding(horizontal = 16.dp)
                    .clip(MaterialTheme.shapes.large)
                    .fillMaxWidth()
                    .background(BackgroundElevated)
                ){
                    TableRow("Amount"){


                        UnstyledTextField(value = "HELLO",
                            onValueChange ={},
                            modifier=Modifier.fillMaxWidth() ,
                            textStyle = TextStyle(
                                textAlign = TextAlign.Right
                            ),
                           keyboardOptions = KeyboardOptions(
                               keyboardType = KeyboardType.Number
                           )

                        )
                    }
                    Divider(
                        modifier = Modifier
                            .padding(start = 1.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow("Recurrence")

                    Divider(
                        modifier = Modifier
                            .padding(start = 1.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow("Date")

                    Divider(
                        modifier = Modifier
                            .padding(start = 1.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow("Note"){

                        UnstyledTextField(value = "HELLO",
                            onValueChange ={},

                            modifier=Modifier.fillMaxWidth() ,
                            textStyle = TextStyle(
                                textAlign = TextAlign.Right
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text
                            )

                        )
                    }

                    Divider(
                        modifier = Modifier
                            .padding(start = 1.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow("Category")
                }
            }
        }
    )

}