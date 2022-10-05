package com.grubclub.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.grubclub.R
import com.grubclub.ui.theme.*

@Composable
fun HomeScreen(navController: NavController) {
    val colors = listOf(Pink, Yellow, Blue, Red, Purple, LightGreen)
    val text = remember { mutableStateOf("") }
    Column(
        Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Green),
            Arrangement.Start,
            Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.profile_img),
                "profile_image",
                Modifier
                    .padding(10.dp)
                    .size(50.dp)
                    .clip(RoundedCornerShape(30.dp)),
            )
            Column {
                Text(
                    "Иванов Иван",
                    fontSize = 18.sp,
                    color = White
                )
                Text(
                    "ivanov@gmail.com",
                    fontSize = 14.sp,
                    color = White
                )
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painterResource(R.drawable.home_img_screen), "",
                Modifier
                    .fillMaxWidth()
                    .height(200.dp), contentScale = ContentScale.FillBounds
            )
            Image(
                painterResource(R.drawable.transparent_rect), "",
                Modifier
                    .fillMaxWidth()
                    .height(200.dp), contentScale = ContentScale.FillBounds
            )
            Text("Выбирай - Покупай\nДругие привезут!", Modifier.padding(35.dp), White, 18.sp)

            Row(
                Modifier
                    .fillMaxWidth(0.7f)
                    .height(70.dp)
                    .padding(8.dp)
                    .clip(CircleShape)
                    .align(Alignment.BottomEnd)
                    .background(White)
                    .alpha(0.8f)
            ) {
                TextField(
                    text.value,
                    { text.value = it },
                    Modifier
                        .fillMaxWidth(0.8f)
                        .alpha(0.8f),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = White,
                        focusedIndicatorColor = White,
                        cursorColor = Green,
                        focusedLabelColor = Green
                    ),
                    textStyle = TextStyle(Black, 16.sp),
                    singleLine = true
                )
                Image(
                    painterResource(R.drawable.magnifier),
                    "profile_image",
                    Modifier
                        .padding(15.dp)
                        .size(50.dp)
                )
            }
        }
        Text(
            "Магазины",
            Modifier
                .fillMaxWidth()
                .padding(12.dp), Black, 18.sp, textAlign = TextAlign.Center
        )
        LazyRow(Modifier.fillMaxWidth()) {
            itemsIndexed(
                listOf(
                    "Лента", "Пятерочка", "OBI", "Wildberries", "Дикси", "Линия",
                )
            ) { _, _ ->
                Image(
                    painterResource(R.drawable.shop_img), "",
                    Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 10.dp)
                .background(Gray)
                .height(2.dp)
        )
        LazyColumn(Modifier.fillMaxHeight()) {
            itemsIndexed(
                listOf(
                    "Доступные заказы", "Акции", "Социум", "Советы", "Настройки", ""
                )
            ) { index, item ->
                Card(
                    Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(horizontal = 30.dp, vertical = 5.dp)
                ) {
                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(colors[index])) {
                        Text(
                            item,
                            Modifier.align(Alignment.Center),
                            Black,
                            18.sp,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}