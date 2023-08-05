package com.example.expensetracker.Components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.expensetracker.R
import com.example.expensetracker.ui.theme.Destructive
import com.example.expensetracker.ui.theme.TextPrimary




@Composable
fun TableRow(label:String,onCLick:(String)->Unit,hasArrow:Boolean = false,isDestructive:Boolean = false){
    val textColor = if (isDestructive ) Destructive else TextPrimary

    Row (modifier=Modifier.fillMaxWidth()
        .clickable {onCLick(label)}
        .padding(horizontal =16.dp,
            vertical = 10.dp),

        horizontalArrangement = Arrangement.SpaceBetween

    )
    {
        Text(text = label, style = MaterialTheme.typography.bodyMedium,color=textColor)

        if(hasArrow)
        {
            Icon(painterResource(id = R.drawable.chevron_right),
                contentDescription = "Right Arrow")
        }
    }
}
