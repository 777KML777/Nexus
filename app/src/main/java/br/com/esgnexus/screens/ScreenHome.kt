package br.com.esgnexus.screens

import android.util.Log
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.esgnexus.R
import br.com.esgnexus.dto.HomeDto
import br.com.esgnexus.dto.RecentPost
import br.com.esgnexus.services.Home.RetrofitFactoryHome
import br.com.esgnexus.ui.theme.NexusTheme
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun ScreenHome(navController: NavController) {
    NexusTheme{
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            ContentHome()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ScreenHomePreview(){
    ContentHome()

    // Components Preview

}

@Composable
fun ContentHome() {

    var homeData = remember {
        mutableStateOf(
                listOf
                    (RecentPost(
                    "",
                    "",
                    "",
                    ""
                    //""
                    )))
    }

    var x = HomeDto(
//        "",
        listOf(RecentPost(
            "",
            "",
            "",
            ""
//            ""
        )));


        // request to api
        var request = RetrofitFactoryHome()
            .homeServiceGetHomeData()
            .homeData("6628c931-7383-4804-ad7c-e655c77bde0e")
        // {TODO} The above code required change enterpriseId to string variable

        val teste = "2024-04-04T16:13:22.834Z"
        Log.e("TESTE SUB STRING", teste.substring(0, teste.length / 2).removeRange(10, 12))
        // error("Irei Enfileirar")

        request.enqueue(object : Callback<HomeDto> {
            override fun onResponse(
                call: Call<HomeDto>,
                response: Response<HomeDto>) {
                // x.enterpriseId = response.body()!!.enterpriseId
                var x = response.body()!!.recentPosts

                homeData.value = x

            }

            override fun onFailure(
                call: Call<HomeDto>,
                t: Throwable) {
                error(t.message.toString())
            }
        })


    // container
    Column (
        modifier = Modifier
            .fillMaxSize(),
            //.background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CompanyTitle()
        MainHeader()

        // RecentPosts()
        Column(modifier = Modifier
            .fillMaxWidth()) {
            SectionTitle("Postagens Recentes", "")
            Spacer(modifier = Modifier.size(size = 15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    //.background(Color.Yellow)

            ) {
                LazyRow() {
                    items (homeData.value.size) {
                        Card(
                            modifier = Modifier
                                .size(150.dp, 220.dp)
                                //.background(Color.Black)
                                .clip(shape = RoundedCornerShape(0.5.dp))
                                //.border(4.dp,Color.Blue,shape = RoundedCornerShape(2.dp)) sobrescreve o Color.Black definido no background
                                .padding(5.dp, 0.dp),
                            border = BorderStroke(1.4.dp, color = Color(0xFF07510A)),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,

                                )


                        ) {
                            Column (
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(70.dp)
                                        .padding(5.dp)
                                ) {
                                // Image. The extension on final is gambiarra
                                AsyncImage(
                                    model = homeData.value[it].image + ".jpeg",
                                    //model = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxSize()
                                )
                            }

                                // datePublish


                            DataFormatted(homeData.value[it].datePost)

                                Text(
                                    text = homeData.value[it].description
                                 )
                            }
                        }

                        /* Text (
                            text = homeData.value.recentPosts[it].description
                        ) */
                    }
                }
                //RecentPostsCard()

                //RecentPostsCard()
                //RecentPostsCard()
                //RecentPostsCard()
            }
        }
    }

}

@Composable
fun DataFormatted2(dataString: String) {
    var i = remember {
         mutableStateOf("")
    }

    i.value = dataString

    val x = dataString.split("-")
    i.value = x[1]+"/"+x[2]

    Column {
        Text(text = i.value)
    }
}

@Composable
fun DataFormatted(dataString: String) {
    if(dataString.isNotEmpty()) {
        val formatoEntrada = DateTimeFormatter.ISO_DATE_TIME
        val formatoSaida = DateTimeFormatter.ofPattern("dd/MM")
        val data = LocalDateTime.parse(dataString, formatoEntrada)
        val diaMesFormatado = data.format(formatoSaida)
        Text(text = diaMesFormatado)
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
fun SectionTitle(title: String, option: String?){
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
            text = option!!,
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Card(
            modifier = Modifier
                .size(width = 80.dp, height = 130.dp)
                .padding(2.dp)
                .clip(shape = RoundedCornerShape(0.5.dp)),
                    border = BorderStroke(width = 1.4.dp, color = Color(0xFF07510A))
        ) {
            Spacer(modifier = Modifier.height(8.5.dp))
            Image(
                painter = painterResource(id = R.drawable.men_women),
                contentDescription = "work Done",
                modifier = Modifier
                    .size(width = 61.dp, height = 35.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "05/09",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 8.sp,
                color = Color(0xFF0D6511),
            )
            Text(
                modifier = Modifier.padding(10.dp, 3.dp, 7.dp, 0.dp),
                text = "It was popularised in the 1960s with the" +
                        " release of Letraset sheets containing Lorem",
                fontSize = 12.sp,
                lineHeight = 9.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Ler mais",
                //textAlign = TextAlign.End,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 5.dp),
                fontSize = 4.sp,
                fontStyle = FontStyle.Italic

            )

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

/* @Composable
fun OldContent () {
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
*/