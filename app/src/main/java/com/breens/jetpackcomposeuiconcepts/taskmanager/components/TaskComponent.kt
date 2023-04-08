package com.breens.jetpackcomposeuiconcepts.taskmanager.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.breens.jetpackcomposeuiconcepts.R
import com.breens.jetpackcomposeuiconcepts.taskmanager.data.Task
import com.breens.jetpackcomposeuiconcepts.ui.theme.LightBlue
import com.breens.jetpackcomposeuiconcepts.ui.theme.LightGreen
import com.breens.jetpackcomposeuiconcepts.ui.theme.LightPurple

@Composable
fun TaskComponent(task: Task) {
    val taskColor = listOf(LightPurple, LightGreen, LightBlue).random()

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${task.startTime}\nAM",
            fontFamily = FontFamily(Font(R.font.nunito_bold)),
            textAlign = TextAlign.Center
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .border(
                        border = BorderStroke(3.dp, Color.Black),
                        shape = CircleShape
                    )
            )

            Divider(modifier = Modifier.width(6.dp), color = Color.Black)

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(14.dp))
                        .background(taskColor)
                        .weight(0.9f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = task.title,
                        fontFamily = FontFamily(Font(R.font.nunito_bold)),
                        modifier = Modifier.padding(
                            start = 12.dp,
                            top = 12.dp
                        )
                    )

                    if (task.body != null) {
                        Text(
                            text = task.body,
                            fontFamily = FontFamily(Font(R.font.nunito_bold)),
                            modifier = Modifier.padding(start = 12.dp),
                            color = Color.Gray
                        )
                    }

                    Text(
                        text = "${task.startTime} - ${task.endTime}",
                        fontFamily = FontFamily(Font(R.font.nunito_bold)),
                        modifier = Modifier.padding(
                            start = 12.dp,
                            bottom = 12.dp
                        )
                    )
                }

                Divider(
                    modifier = Modifier
                        .width(6.dp)
                        .weight(0.1f), color = Color.Black
                )
            }
        }
    }
}