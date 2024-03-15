package br.com.esgnexus.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.esgnexus.R
import br.com.esgnexus.ui.theme.NexusTheme

@Composable
fun ScreenHome(navController: NavController) {
    NexusTheme{
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    CompanyTitle()
                    Spacer(modifier = Modifier.size(size = 35.dp))
                    ButtonOptions()
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(horizontal = 35.dp)
                    ) {
                        MainHeader()
                        Spacer(modifier = Modifier.size(size = 35.dp))
                        RecentPosts()
                        Spacer(modifier = Modifier.size(size = 35.dp))
                        //CompanyStatistics()


                    }
                    Column (
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier
                            .fillMaxHeight()
                    ) {
                        Rodape()
                    }

                }
            }
        }
    }
}

@Composable
fun CompanyTitle(){
    Row(
        modifier = Modifier
            .background(Color(0xff2A933E))
            .fillMaxWidth()
    ){
        Image(
            painter = painterResource(id = R.drawable.logohome),
            contentDescription = "Header",
            modifier = Modifier
                .size(width = 100.dp, height = 35.dp)
                .align(Alignment.CenterVertically)

        )
        // Forgot Your Password
        Button(
            modifier = Modifier
                .fillMaxWidth()
                // .padding(start = 16.dp, top = 20.dp, end = 16.dp, bottom = 0.dp)
                .wrapContentWidth(Alignment.End, true),
            colors = ButtonDefaults.buttonColors(Color.Unspecified),

            onClick = {

            }
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "",
                tint = Color(255, 255, 255)
            )
        }
    }

}

@Composable
fun MainHeader(){
    Column(

    )   {
        Image(
            painter = painterResource(id = R.drawable.grafico),
            contentDescription = "Header",
            modifier = Modifier.size(width = 380.dp, height = 300.dp)
        )

        Text(
            text = "Histórico",
            color = Color(0xff07510A),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.align(Alignment.End)
        )
    }

}

@Composable
fun SectionTitle(title: String, option: String){
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            color = Color(0xff0D6511),
            fontSize = 22.sp,
        )
        Text(
            text = option,
            color = Color(0xff07510A),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier

        )
    }
}

@Composable
fun RecentPostsCard(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier
                .size(width = 80.dp, height = 130.dp)
                .clip(
                    shape = RoundedCornerShape(0.5.dp)
                )
        ) {
        }
        Card(
            modifier = Modifier
                .offset(y = (-15).dp)
                //.fillMaxWidth()
                //.height(300.dp),
                .size(30.dp),
            colors = CardDefaults
                .cardColors(containerColor = Color(0xfff9f6f6)),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = CircleShape,
            border = BorderStroke(width = 1.dp, color = Color.Gray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(width = 350.dp, height = 230.dp)
            )
        }
    }
}

@Composable
fun RecentPosts(){
    Column(modifier = Modifier
        .fillMaxWidth()) {
        SectionTitle("Postagens Recentes", "Ver todos")
        Spacer(modifier = Modifier.size(size = 15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RecentPostsCard()
            RecentPostsCard()
            RecentPostsCard()
            RecentPostsCard()
        }
    }
}

@Composable
fun DailyChart(day: String, height: Int){
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Card(modifier = Modifier
            .size(width = 30.dp, height = height.dp)
            .border(width = 2.dp, color = Color(0xff000000))) {}
        Text(
            text = day,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}
@Composable
fun WeekChart(){
    Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom) {
        DailyChart("D", 50)
        DailyChart("S", 75)
        DailyChart("T", 125)
        DailyChart("Q", 75)
        DailyChart("Q", 65)
        DailyChart("S", 150)
        DailyChart("S", 35)
        DailyChart("D", 65)
    }
}

@Composable
fun CompanyStatistics(){
    Column(modifier = Modifier
        .fillMaxWidth()) {
        SectionTitle("Estatística da Empresa", "Histórico")
        Spacer(modifier = Modifier.size(size = 15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            WeekChart()
        }
    }
}

@Composable
fun ButtonOptions () {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Card 1
        Card(
            modifier = Modifier
                .background(Color.White)
                .size(width = 100.dp, height = 50.dp)
                .clip(shape = RoundedCornerShape(0.5.dp)),
            border = CardDefaults.outlinedCardBorder(
                enabled = true,
            )


            //.border(1.dp, Color(0xff2A933E))

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
            ) {

                Icon(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    imageVector = Icons.Default.Star,
                    contentDescription = "",
                    tint = Color(0, 0, 0)
                )

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Benefícios",
                    color = Color(0xff07510A),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,

                    )
            }
        }

        //Card 2
        Card(
            modifier = Modifier
                .background(Color.White)
                .size(width = 100.dp, height = 50.dp)
                .clip(shape = RoundedCornerShape(0.5.dp)),
            border = CardDefaults.outlinedCardBorder(
                enabled = true,
            )


            //.border(1.dp, Color(0xff2A933E))

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
            ) {

                Icon(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    imageVector = Icons.Default.Star,
                    contentDescription = "",
                    tint = Color(0, 0, 0)
                )

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Editar Equipe",
                    color = Color(0xff07510A),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,

                    )
            }
        }

        // Card 3
        Card(
            modifier = Modifier
                .background(Color.White)
                .size(width = 100.dp, height = 50.dp)
                .clip(shape = RoundedCornerShape(0.5.dp)),
            border = CardDefaults.outlinedCardBorder(
                enabled = true,
            )


            //.border(1.dp, Color(0xff2A933E))

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
            ) {

                Icon(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    imageVector = Icons.Default.Star,
                    contentDescription = "",
                    tint = Color(0, 0, 0)
                )

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Feedbacks",
                    color = Color(0xff07510A),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,

                    )
            }
        }


        //Card 4
        Card(
            modifier = Modifier
                .background(Color.White)
                .size(width = 100.dp, height = 50.dp)
                .clip(shape = RoundedCornerShape(0.5.dp)),
            border = CardDefaults.outlinedCardBorder(
                enabled = true,
            )


            //.border(1.dp, Color(0xff2A933E))

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
            ) {

                Icon(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    imageVector = Icons.Default.Star,
                    contentDescription = "",
                    tint = Color(0, 0, 0)
                )

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Ver Pontuações",
                    color = Color(0xff07510A),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,

                    )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ScreenHomePreview(){
    val navController = rememberNavController()
    ScreenHome(navController)
}

@Composable
fun Rodape () {
    Row(

        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(Color(0xffD9D9D9))
            .fillMaxWidth()
            .height(63.dp)


    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "",
            tint = Color(0xff61646B)
        )

        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "",
            tint = Color(0xff61646B)
        )
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = "",
            tint = Color(0xff61646B)
        )
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "",
            tint = Color(0xff61646B)
        )

        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "",
            tint = Color(0xff61646B)
        )

        }
}

