package com.example.expensetracker.pages
// Mir Niyazul Haque
// This app is going to Rock !!
import android.app.DatePickerDialog
import android.os.Build

import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.Components.TableRow
import com.example.expensetracker.Components.UnstyledTextField
import com.example.expensetracker.models.Recurrence
import com.example.expensetracker.ui.theme.BackgroundElevated
import com.example.expensetracker.ui.theme.DividerColor
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme
import com.example.expensetracker.ui.theme.Primary
import com.example.expensetracker.ui.theme.Shapes
import com.example.expensetracker.ui.theme.TopAppBarBackground
import com.example.expensetracker.viewmodels.AddViewModel
import com.marosseleng.compose.material3.datetimepickers.date.ui.dialog.DatePickerDialog
import java.time.LocalDate
import java.util.Calendar
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Add(navController:NavController, vm: AddViewModel= viewModel())
{ // For Recurrence Tab

    val state by vm.uiState.collectAsState()
    val recurrences = listOf(
        Recurrence.None,
        Recurrence.Daily,
        Recurrence.Weekly,
        Recurrence.Monthly,
        Recurrence.Yearly
    )

    // For Category Tab
    val categories = listOf(
        "Groceries",
        "Bills",
        "Hobbies",
        "Take Out",
        "Party"
    )

    Scaffold (
        topBar = {
            MediumTopAppBar(title = { Text( "Add") }, colors = TopAppBarDefaults
                .mediumTopAppBarColors(containerColor = TopAppBarBackground))
        },
        content = {innerPadding->
            Column(modifier= Modifier.padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Column ( modifier= Modifier
                    .padding(horizontal = 16.dp)
                    .clip(MaterialTheme.shapes.large)
                    .fillMaxWidth()
                    .background(BackgroundElevated)
                ) {
                    TableRow(label = "Amount", detailcontent = {
                        UnstyledTextField(
                            value = state.amount,
                            onValueChange = vm::setAmount,
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text(text = "0") },
                            arrangement = Arrangement.End,
                            maxLines = 1,
                            textStyle = TextStyle(
                                textAlign = TextAlign.Right
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )

                        )
                    })
                    Divider(
                        modifier = Modifier
                            .padding(start = 1.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow(label = "Recurrence", detailcontent = {
                        var recurrenceMenuOpened by remember { mutableStateOf(false) }

                        TextButton(
                            onClick = { recurrenceMenuOpened = true }, shape = Shapes.large

                        )
                        {
                            Text(state.recurrence?.name ?: Recurrence.None.name)
                            DropdownMenu(expanded = recurrenceMenuOpened,
                                onDismissRequest = { recurrenceMenuOpened = false }
                            )
                            {
                                recurrences.forEach { recurrence ->

                                    DropdownMenuItem(
                                        text = { Text(recurrence.name) },

                                        onClick = {
                                            vm.setRecurrence(recurrence)
                                            recurrenceMenuOpened = false


                                        }

                                    )
                                }


                            }
                        }
                    }
                    )


                    Divider(
                        modifier = Modifier
                            .padding(start = 1.dp), thickness = 1.dp, color = DividerColor
                    )
                    var datePickerShowing by remember {
                        mutableStateOf(false)
                    }
                    TableRow(label = "Date", detailcontent = {
                        TextButton(onClick = { datePickerShowing = true }) {
                            Text(state.date.toString())

                        }
                        if (datePickerShowing) {

                            DatePickerDialog(
                                onDismissRequest = { datePickerShowing = false },
                                onDateChange = { it ->
                                    vm.setDate(it)
                                    datePickerShowing = false
                                },
                                initialDate = state.date,
                                title = {
                                    Text(
                                        text = "Select a Date",
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                }
                            )
                        }
                    })






                    Divider(
                        modifier = Modifier
                            .padding(start = 1.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow(label = "Note", detailcontent = {
                        UnstyledTextField(
                            value = state.note,
                            placeholder = { Text(text = "Add some Notes") },
                            arrangement = Arrangement.End,
                            onValueChange = vm::setNote,

                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(
                                textAlign = TextAlign.Right
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text
                            )

                        )
                    })

                    Divider(
                        modifier = Modifier
                            .padding(start = 1.dp), thickness = 1.dp, color = DividerColor
                    )
                    TableRow(label = "Category", detailcontent = {
                        var categoriesMenuOpened by remember{mutableStateOf(false)}

                        TextButton(onClick = { categoriesMenuOpened=true }, shape = Shapes.large

                        )// error might contain
                        {
                            Text(state.category ?:"Select a Category ")
                            DropdownMenu(expanded =categoriesMenuOpened ,
                                onDismissRequest = {categoriesMenuOpened=false }
                            )
                            {
                                categories.forEach{category->

                                    DropdownMenuItem(

                                        text = {
                                            Row (verticalAlignment = Alignment.CenterVertically){
                                                Surface (modifier=Modifier.size(10.dp),shape= CircleShape,color= Primary){}
                                                Text(category,modifier=Modifier.padding(start = 8.dp))




                                            }

                                        },

                                        onClick = {
                                            vm.setCategory(category)
                                            categoriesMenuOpened= false


                                        }

                                    )
                                }



                            }
                        }
                    }
                    )



                }
            
            Button(onClick = { /*TODO*/ },
                modifier=Modifier.padding(16.dp),
                shape = Shapes.large

            )
            {
                Text(text = "Submit")
            }
            }
            
        }
    )

}




@Preview(showBackground = true)
@Composable
fun AddPreview(){
    ExpenseTrackerTheme {
        val navController = rememberNavController()

        Add(navController = rememberNavController())
    }

}