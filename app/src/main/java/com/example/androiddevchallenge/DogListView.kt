/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:JvmName("DogListViewKt")

package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.bean.DogBean

@Composable
fun DogListView(
    navController: NavController,
    dogList: List<DogBean>
) {
    Surface(Modifier.fillMaxSize()) {
        LazyColumn {
            items(dogList) {
                ItemCard(
                    it,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun ItemCard(
    dog: DogBean,
    navController: NavController,
) {
    Card(
        Modifier
            .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
            .width(Dp.Unspecified)
            .height(100.dp)
            .clickable(
                onClick = {
                    navController.navigate("dog_detail/${dog.name}/${dog.age}/${dog.imgResId}")
                }
            ),
        elevation = 4.dp, backgroundColor = Color.White
    ) {
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = dog.imgResId),
                    contentDescription = null,
                )
                Column {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "name:",
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                        )
                        Text(dog.name, color = Color.Black)
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "age:    ",
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                        )
                        Text(dog.age, color = Color.Black)
                    }
                }
            }
        }
    }
}
