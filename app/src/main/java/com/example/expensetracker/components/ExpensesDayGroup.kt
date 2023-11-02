package com.example.expensetracker.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expensetracker.models.DayExpenses
import com.example.expensetracker.ui.theme.LabelSecondary
import com.example.expensetracker.ui.theme.Typography
import com.example.expensetracker.utils.formatDay
import java.text.DecimalFormat
import java.time.LocalDate
@Composable
fun ExpensesDayGroup(
    date: LocalDate,
    dayExpenses: DayExpenses,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            date.formatDay(),
            style = MaterialTheme.typography.headlineMedium,
            color = LabelSecondary
        )
        Divider(modifier = Modifier.padding(top = 10.dp, bottom = 4.dp))
        dayExpenses.expenses.forEach { expense ->
            ExpenseRow(
                expense = expense,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
        Divider(modifier = Modifier.padding(top = 16.dp, bottom = 4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Total:", style = MaterialTheme.typography.bodyMedium, color = LabelSecondary)
            Text(
                DecimalFormat("IND 0.#").format(dayExpenses.total),
                style = MaterialTheme.typography.headlineMedium,
                color = LabelSecondary
            )
        }
    }
}