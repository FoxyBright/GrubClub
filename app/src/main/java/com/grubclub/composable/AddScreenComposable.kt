package com.grubclub.composable

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.grubclub.R
import com.grubclub.ui.theme.Black
import com.grubclub.ui.theme.Green
import com.grubclub.ui.theme.White

@Composable
fun AddScreen(navController: NavController) {
    val context = LocalContext.current
    Box(
        Modifier
            .fillMaxHeight(0.8f)
            .fillMaxWidth()
    )
    Column(
        Modifier
            .fillMaxSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "НОВЫЙ ЗАКАЗ",
            Modifier.padding(20.dp),
            Black,
            24.sp
        )
        Box(
            Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth()
        ) {
            Image(
                painterResource(R.drawable.top_receipt),
                "",
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .align(Alignment.TopCenter),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painterResource(R.drawable.vertical_receipt),
                "",
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 40.dp)
                    .align(Alignment.Center),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painterResource(R.drawable.bottom_receipt),
                "",
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .align(Alignment.BottomCenter),
                contentScale = ContentScale.FillBounds
            )
        }
        Button(
            {
                Toast.makeText(context, "Заказ создан", Toast.LENGTH_SHORT).show()
            },
            Modifier
                .fillMaxWidth()
                .padding(40.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Green)
        ) {

        }
    }
}

@Preview
@Composable
fun AddScreenPreview() {
    AddScreen(rememberNavController())
}