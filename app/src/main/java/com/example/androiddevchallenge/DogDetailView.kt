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
@file:JvmName("DogDetailViewKt")

package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DogDetailView(
    name: String,
    age: String,
    imgResId: Int,
) {

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(16.dp)
            .width(Dp.Unspecified)
            .height(450.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(elevation = 4.dp) {
                Image(
                    painter = painterResource(id = imgResId),
                    contentDescription = null,
                    modifier = Modifier
                        .width(300.dp)
                        .height(300.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            Text(
                "My name is $name", color = Color.Black
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text("I'm $age", color = Color.Black)
        }
    }
}
