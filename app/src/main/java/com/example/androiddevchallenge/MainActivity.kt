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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.bean.DogBean
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyTheme {
                ComposeNavigation()
            }
        }
    }
}

@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "dog_list"
    ) {
        composable("dog_list") {
            val list = mutableListOf<DogBean>()
            val dog1 = DogBean("Ciel", "3 years old", R.mipmap.dog1)
            val dog2 = DogBean("Ulrica", "5 years old", R.mipmap.dog2)
            val dog3 = DogBean("Bebe", "2 years old", R.mipmap.dog3)
            val dog4 = DogBean("Cecilia", "1 years old", R.mipmap.dog4)
            val dog5 = DogBean("Kira", "6 years old", R.mipmap.dog5)
            val dog6 = DogBean("Skye", "3 years old", R.mipmap.dog6)
            val dog7 = DogBean("Snow", "5 years old", R.mipmap.dog7)
            val dog8 = DogBean("Felicia", "2 years old", R.mipmap.dog8)
            val dog9 = DogBean("Danae", "4 years old", R.mipmap.dog9)
            list.add(dog1)
            list.add(dog2)
            list.add(dog3)
            list.add(dog4)
            list.add(dog5)
            list.add(dog6)
            list.add(dog7)
            list.add(dog8)
            list.add(dog9)
            DogListView(navController = navController, dogList = list)
        }
        composable(
            "dog_detail/{name}/{age}/{imgResId}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("age") { type = NavType.StringType },
                navArgument("imgResId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            DogDetailView(
                backStackEntry.arguments?.getString("name")!!,
                backStackEntry.arguments?.getString("age")!!,
                backStackEntry.arguments?.getInt("imgResId")!!
            )
        }
    }
}
