package br.com.esgnexus.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.esgnexus.components.RadioButtonComponent
import br.com.esgnexus.ui.theme.WorkSans

@Composable
fun ScreenLogin(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)


    ){
        Column(
            horizontalAlignment =  Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.Center)
                //.background(Color.Gray)
                .fillMaxWidth()
                .offset(y = (-80).dp)
                //.fillMaxSize()
        ) {
            Text(
                color = Color.Black,
                fontFamily = WorkSans,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                text = "Nexus",
            )

            var email = remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = email.value,
                onValueChange = {email.value = it},
                label = {
                    Text(
                        //modifier = Modifier.offset(y = (-20).dp),
                        text = "Email"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    //.padding(horizontal =  32.dp)
                    .padding(
                        start = 16.dp,
                        top = 20.dp,
                        end = 16.dp,
                        bottom = 0.dp
                    )
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(text = "Senha")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 10.dp,
                        end = 16.dp,
                        bottom = 0.dp
                    )
            )

            // Forgot Your Password
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 20.dp,
                        end = 16.dp,
                        bottom = 0.dp
                    )
                    .wrapContentWidth(Alignment.End, true),
                colors = ButtonDefaults.buttonColors(Color.Unspecified),

                onClick = {

                }
            ) {
                Text(
                    text = "Esqueceu a senha?"
                )
            }


            //Radio Button
            RadioButtonComponent()


            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    //.padding(horizontal =  32.dp)
                    .padding(
                        start = 16.dp,
                        top = 20.dp,
                        end = 16.dp,
                        bottom = 0.dp
                    ),
                onClick = {

                },
                shape = RectangleShape

            ) {
                Text(
                    text = "Entrar"
                )
            }

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    //.padding(horizontal =  32.dp)
                    .padding(
                        start = 16.dp,
                        top = 20.dp,
                        end = 16.dp,
                        bottom = 0.dp
                    ),
                onClick = {

                },
                //shape = RectangleShape,
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Text(
                    text = "Entrar com uma conta Google"
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    //.padding(horizontal =  32.dp)
                    .padding(
                        start = 16.dp,
                        top = 20.dp,
                        end = 16.dp,
                        bottom = 0.dp
                    ),
                onClick = {

                }
            ) {
                Text(
                    text = "Entrar com uma Email"
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    //.padding(horizontal =  32.dp)
                    .padding(
                        start = 16.dp,
                        top = 20.dp,
                        end = 16.dp,
                        bottom = 0.dp
                    ),
                onClick = {

                }
            ) {
                Text(
                    text = "Ainda não possui cadastro?"
                )
            }
        }
    }
}

// TODO

// Generate exe to test in others devices
// define padding top
// Draw a prototype what the screen needs to be code
    // A center box with property offset set.
// First put components on the screen
// Then implement states
// LoginScreen --> Images
// LoginScreen --> Learn about Position
// LoginScreen --> Set mock data for app's users
// When click in outlined set a new value for offset.
// ScreenHome --> Implement ViewPager on ScreenHome

// App --> Install Font
    // download it in https://fonts.google.com/
    // take fonts that you need and refactor them
    // Add config in Type.kt
// App --> Set application's icon
// App --> Set & Use Components including ViewPager
// LoginScreen --> Api Authentication
