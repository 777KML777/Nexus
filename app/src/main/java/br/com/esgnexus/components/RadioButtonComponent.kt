package br.com.esgnexus.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RadioButtonComponent () {
  Row(
      horizontalArrangement = Arrangement.Start,
      modifier = Modifier
          //.background(Color.Black)
          .fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically


  ) {
      RadioButton(
        selected = false,
        onClick = {},
        colors = RadioButtonDefaults.colors(
            selectedColor = Color(0xff2A933E),
            unselectedColor = Color(0xff2A933E)
        )
      )
      Text(
          text = "Manter-me conectado",
          color = Color(0xff2A933E)
      )
  }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonComponentPreview () {
    RadioButtonComponent()
}