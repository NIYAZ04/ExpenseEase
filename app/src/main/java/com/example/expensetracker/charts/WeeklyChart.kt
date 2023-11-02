package com.example.expensetracker.charts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.example.expensetracker.models.Expense
import com.example.expensetracker.models.groupedByDayOfWeek
import com.example.expensetracker.ui.theme.LabelSecondary
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.BarChartData.Bar
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer
import com.github.tehras.charts.bar.renderer.yaxis.SimpleYAxisDrawer

import java.time.DayOfWeek

@Composable
fun WeeklyChart( expenses: List<Expense>){

    val groupedExpenses = expenses.groupedByDayOfWeek()

    BarChart(barChartData = BarChartData(
        bars= listOf(

            BarChartData.Bar(
                label=DayOfWeek.MONDAY.name.substring(0,1),
                value = groupedExpenses[DayOfWeek.MONDAY.name]?.total?.toFloat()?:0f,
                color = Color.White
            ),

            Bar(
                label=DayOfWeek.TUESDAY.name.substring(0,1),
                value = groupedExpenses[DayOfWeek.MONDAY.name]?.total?.toFloat()?:0f,
                color = Color.White
            ),
            Bar(
                label=DayOfWeek.WEDNESDAY.name.substring(0,1),
                value = groupedExpenses[DayOfWeek.MONDAY.name]?.total?.toFloat()?:0f,
                color = Color.White
            ),
            Bar(
                label=DayOfWeek.THURSDAY.name.substring(0,1),
                value = groupedExpenses[DayOfWeek.MONDAY.name]?.total?.toFloat()?:0f,
                color = Color.White
            ),
            Bar(
                label=DayOfWeek.FRIDAY.name.substring(0,1),
                value = groupedExpenses[DayOfWeek.MONDAY.name]?.total?.toFloat()?:0f,
                color = Color.White
            ),
            Bar(
                label=DayOfWeek.SATURDAY.name.substring(0,1),
                value = groupedExpenses[DayOfWeek.MONDAY.name]?.total?.toFloat()?:0f,
                color = Color.White
            ),
            Bar(
                label=DayOfWeek.SUNDAY.name.substring(0,1),
                value = groupedExpenses[DayOfWeek.MONDAY.name]?.total?.toFloat()?:0f,
                color = Color.White
            ),

        ),


    ),
        labelDrawer =LabelDrawer(),
        yAxisDrawer = SimpleYAxisDrawer(

          labelTextColor = LabelSecondary
        ),
        barDrawer=BarDrawer(),



        modifier=Modifier.height(147.dp).fillMaxWidth()

    )

}