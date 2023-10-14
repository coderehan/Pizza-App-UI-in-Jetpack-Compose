package com.example.pizzaappinjetpackcompose.data

import androidx.annotation.DrawableRes
import com.example.pizzaappinjetpackcompose.R

data class PizzaData(
    @DrawableRes val image: Int,
    val name: String,
    val description: String,
    val price: String
)

val pizzaList = listOf(
    PizzaData(
        R.drawable.pizza_one,
        "Fresh Farm House",
        "crisp capsicum, succulent mushrooms and fresh tomatoes",
        "£14.25"
    ),
    PizzaData(
        R.drawable.pizza_two,
        "Peppy Paneer",
        "Chunky paneer with crisp capsicum and spicy red pepper",
        "£16.75"
    ),
    PizzaData(
        R.drawable.pizza_three,
        "Mexican Green Wave",
        "A pizza loaded with crunchy onions, crisp capsicum, juicy tomatoes",
        "£10.25"
    ),
    PizzaData(
        R.drawable.pizza_four,
        "Fresh Farm House",
        "crisp capsicum, succulent mushrooms and fresh tomatoes",
        "£14.25"
    ),
    PizzaData(
        R.drawable.pizza_one,
        "Fresh Farm House",
        "crisp capsicum, succulent mushrooms and fresh tomatoes",
        "£14.25"
    ),
    PizzaData(
        R.drawable.pizza_two,
        "Peppy Paneer",
        "Chunky paneer with crisp capsicum and spicy red pepper",
        "£19.25"
    ),
    PizzaData(
        R.drawable.pizza_three,
        "Fresh Farm House",
        "crisp capsicum, succulent mushrooms and fresh tomatoes",
        "£14.25"
    ),
    PizzaData(
        R.drawable.pizza_four,
        "Fresh Farm House",
        "crisp capsicum, succulent mushrooms and fresh tomatoes",
        "£14.25"
    ),
)