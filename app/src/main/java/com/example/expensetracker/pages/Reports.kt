package com.example.expensetracker.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expensetracker.charts.WeeklyChart
import com.example.expensetracker.expensesList.ExpensesList
import com.example.expensetracker.mock.mockExpenses
import com.example.expensetracker.ui.theme.LabelSecondary
import com.example.expensetracker.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Reports(){
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text("Reports") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground
                )
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Column {
                        Text ("12 - Sep - 18 - sep",style=MaterialTheme.typography.titleMedium)
                        Row (modifier=Modifier.padding(top=4.dp)){
                            Text("INR",style=MaterialTheme.typography.bodyMedium,color= LabelSecondary,modifier = Modifier.padding(end=4.dp))
                            Text("85",style=MaterialTheme.typography.headlineMedium)
                        }

                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text("Avg/day", style = MaterialTheme.typography.titleSmall)
                        Row(modifier = Modifier.padding(top = 4.dp)) {
                            Text(
                                "INR",
                                style = MaterialTheme.typography.bodyMedium,
                                color = LabelSecondary,
                                modifier = Modifier.padding(end = 4.dp)
                            )
                            Text("85", style = MaterialTheme.typography.headlineMedium)
                        }
                    }
                }


                //chart

                Box(modifier = Modifier.padding(vertical=16.dp)) {
                    WeeklyChart(expenses = mockExpenses)
                }


              ExpensesList(
                  expenses = mockExpenses,
                  modifier= Modifier
                      .weight(1f)
                      .verticalScroll(
                          rememberScrollState()
                      ))
            }

        }
    )
}
