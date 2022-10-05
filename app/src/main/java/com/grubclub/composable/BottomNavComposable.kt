package com.grubclub.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.grubclub.R
import com.grubclub.ui.theme.White

@Composable
fun BottomNav(navController: NavController) {
    Box(
        Modifier
            .fillMaxWidth()
            .background(White)
    ) {
        Image(
            painterResource(R.drawable.left),
            "",
            Modifier
                .fillMaxWidth(0.4f)
                .align(Alignment.BottomStart),
            contentScale = ContentScale.FillWidth
        )
        Image(
            painterResource(R.drawable.right),
            "",
            Modifier
                .fillMaxWidth(0.4f)
                .align(Alignment.BottomEnd),
            contentScale = ContentScale.FillWidth
        )
        Row(
            Modifier
                .fillMaxWidth(0.4f)
                .align(Alignment.BottomStart)
                .padding(bottom = 2.dp, start = 15.dp, end = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painterResource(R.drawable.home), "",
                    Modifier
                        .size(32.dp)
                        .clickable {
                            navController.navigate("Home")
                        })
                Text("Главная", fontSize = 12.sp, color = Color.White)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painterResource(R.drawable.map), "",
                    Modifier
                        .size(32.dp)
                        .clickable {
                            navController.navigate("Map")
                        })
                Text("Карта", fontSize = 12.sp, color = Color.White)
            }
        }
        Box(Modifier.fillMaxWidth()) {
            Image(
                painterResource(R.drawable.add),
                "",
                Modifier
                    .padding(5.dp)
                    .size(60.dp)
                    .align(Alignment.Center)
                    .clickable {
                        navController.navigate("Add")
                    }
            )
        }
        Row(
            Modifier
                .fillMaxWidth(0.4f)
                .align(Alignment.BottomEnd)
                .padding(bottom = 2.dp, start = 25.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painterResource(R.drawable.history), "",
                    Modifier
                        .size(32.dp)
                        .clickable {
                            navController.navigate("History")
                        })
                Text("История", fontSize = 12.sp, color = Color.White)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painterResource(R.drawable.backet), "",
                    Modifier
                        .size(32.dp)
                        .clickable {
                            navController.navigate("Basket")
                        })
                Text("Корзина", fontSize = 12.sp, color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun BottomNavPreview() {
    BottomNav(rememberNavController())
}