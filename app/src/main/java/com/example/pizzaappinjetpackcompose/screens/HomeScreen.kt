package com.example.pizzaappinjetpackcompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaappinjetpackcompose.R
import com.example.pizzaappinjetpackcompose.common.AppIconButton
import com.example.pizzaappinjetpackcompose.common.SpacerHeight
import com.example.pizzaappinjetpackcompose.common.SpacerWidth
import com.example.pizzaappinjetpackcompose.data.PizzaData
import com.example.pizzaappinjetpackcompose.data.pizzaList
import com.example.pizzaappinjetpackcompose.ui.theme.DarkBlackColor
import com.example.pizzaappinjetpackcompose.ui.theme.LightGrayColor
import com.example.pizzaappinjetpackcompose.ui.theme.OrangeColor
import com.example.pizzaappinjetpackcompose.ui.theme.YellowColor

@Preview(showBackground = true)
@Composable
fun HomeScreen() {

    val chipMenuList =
        listOf(
            "Starter",
            "Asian",
            "Placha & Roast & Grill",
            "Classic",
            "Indian",
            "Italian",
            "Starter",
            "Asian",
            "Placha & Roast & Grill",
            "Classic",
            "Indian",
            "Italian"
        )

    // Here we specified "Starter" is the current chip selector
    var currentChipMenuState by remember {
        mutableStateOf("Starter")
    }
    val scrollState = rememberScrollState()

    // Our whole UI design will come under Box
    // Its better practise to create separate composable functions for every separate ui components instead of writing all ui design in one composable function.

    // We will keep all ui components inside Box.
    Box(
        modifier = Modifier
            .fillMaxSize()                      // It will take both entire screen width and entire screen height
            .background(color = LightGrayColor)        // This is the color of activity screen
    ) {
        Column {
            // This is for header
            PizzaHeader()
            // This is for chips selection
            Card(
                modifier = Modifier
                    .fillMaxWidth(),     // It is taking entire width
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(scrollState)  // Row will be horizontally scrollable
                ) {
                    chipMenuList.forEach {
                        CustomChip(
                            title = it,
                            selected = it == currentChipMenuState,
                            onValueChange = {
                                currentChipMenuState = it
                            })
                    }
                }
            }
            // This is for showing pizza data in gridview
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {    // 2 content will be shown in single row
                // We will show list of pizza
                items(pizzaList) {
                    ShowPizza(pizzaData = it)
                }
            }
        }

        // This is for floating action button
        FloatingActionButton(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 30.dp)
                .align(Alignment.BottomEnd)
        )

    }
}

@Composable
fun PizzaHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()     // It will take entire width
            .background(color = OrangeColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()     // It will take entire width
                .padding(
                    vertical = 20.dp,        // Vertical means top & bottom is 20dp and horizontal means start & end is 10dp
                    horizontal = 10.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween        // Maximum space will be shared between these 2 row items
        ) {       // Row start
            Row {  // Row start
                AppIconButton(
                    icon = R.drawable.menu
                )
                SpacerWidth(10.dp)
                Text(
                    text = "Pizza App UI",
                    style = TextStyle(
                        fontWeight = FontWeight.W600,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                )
            }       // Row end
            AppIconButton(
                icon = R.drawable.search
            )
        }       // Row end
    }
}

@Composable
fun CustomChip(
    title: String,      // In chip, we have title inside it
    selected: Boolean,   // This is for selecting particular chip among chips
    onValueChange: (String) -> Unit     // Here we are defining string because we are updating title of chip when user select particular chip
) {
    // We will use TextButton composable for designing chips
    TextButton(
        onClick = {
            onValueChange(title)
        },
        shape = RoundedCornerShape(500.dp),     // Chips are in rounded corner shape
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) YellowColor else Color.Transparent       // container color is the background color of button
        ),
        border = BorderStroke(1.dp, color = YellowColor),
        modifier = Modifier.padding(vertical = 15.dp, horizontal = 10.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                color = if (selected) Color.White else DarkBlackColor     // If we click on particular chip, text color will show in described white color and other chips text color will be in DarkBlackColor
            )
        )
    }
}

@Composable
fun ShowPizza(
    pizzaData: PizzaData
) {
    Card(
        modifier = Modifier
            .padding(vertical = 3.dp, horizontal = 4.dp),
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        // Box is used as we have to center image & text inside card
        Box(
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pizza_one),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp)
                )
                SpacerHeight()
                Text(
                    text = pizzaData.price,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W300,
                        color = Color.Red,
                        textAlign = TextAlign.Center
                    )
                )
                SpacerHeight()
                Text(
                    text = pizzaData.name,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                )
                Text(
                    text = pizzaData.description,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.LightGray,
                        textAlign = TextAlign.Center
                    )
                )
                SpacerHeight()
                Button(
                    onClick = { },
                    modifier = Modifier.width(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = YellowColor
                    )
                ) {
                    Text(
                        text = "Add",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W600,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
        }
    }

}

@Composable
fun FloatingActionButton(modifier: Modifier) {
    Box(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(27.dp))
            .background(DarkBlackColor)
    ) {
        // Inside this box, we will show two things 1. button 2. image icon
        // So we will use row to achieve this.
        Row {
            SpacerWidth(20.dp)
            Text(
                text = "$100.5",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.White
                ),
                modifier = Modifier.align(CenterVertically)
            )
            Icon(
                painter = painterResource(id = R.drawable.pizza_one),
                contentDescription = "",
                modifier = Modifier
                    .size(46.dp)
                    .padding(2.dp),
                tint = Color.Unspecified
            )
        }
    }
}