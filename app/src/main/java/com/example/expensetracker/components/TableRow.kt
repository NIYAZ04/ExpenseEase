package com.example.expensetracker.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.expensetracker.R
import com.example.expensetracker.ui.theme.Destructive
import com.example.expensetracker.ui.theme.TextPrimary

@Composable
fun TableRow( modifier:Modifier=Modifier,label:String ? =null, hasArrow:Boolean = false, isDestructive:Boolean = false, detailcontent:(@Composable RowScope.()-> Unit)?=null,
              content:(@Composable RowScope.()-> Unit)?=null){

    val textColor = if (isDestructive ) Destructive else TextPrimary



    Row (
        modifier= modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

    )
    {if(label!=null){
        Text(text = label,
            style =typography.bodyMedium,
            color=textColor
            ,modifier=Modifier.padding( vertical = 10.dp))
    }
if(content !=null){
    content()
}

        if(hasArrow)
        {
            Icon(
                painterResource(id = R.drawable.chevron_right),
                contentDescription = "Right Arrow",
                modifier=Modifier.padding( vertical = 10.dp)
            )
        }

        if(detailcontent!=null){
            detailcontent()
        }

    }//Row Composable Ending
}
