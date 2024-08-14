package com.example.colcheiaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.colcheiaapp.ui.theme.ColcheiaappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColcheiaappTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF333333)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.DarkGray)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // App Icon
            Image(
                painter = painterResource(id = R.drawable.ic_music_note),
                contentDescription = "App Icon",
                modifier = Modifier.size(64.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Login Text
            Text(
                text = "Colcheia App",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email Input
            BasicTextField(
                value = email.value,
                onValueChange = { email.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(16.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (email.value.isEmpty()) {
                        Text("Email", color = Color.Gray)
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Password Input
            BasicTextField(
                value = password.value,
                onValueChange = { password.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(16.dp),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                decorationBox = { innerTextField ->
                    if (password.value.isEmpty()) {
                        Text("Password", color = Color.Gray)
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Sign In Button
            Button(onClick = {
                // Handle sign in logic here
            }) {
                Text("Sign In")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Social Login Buttons
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google Sign In",
                    modifier = Modifier
                        .size(48.dp)
                        .clickable {
                            // Handle Google sign in
                        }
                )

                Spacer(modifier = Modifier.width(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "Facebook Sign In",
                    modifier = Modifier
                        .size(48.dp)
                        .clickable {
                            // Handle Facebook sign in
                        }
                )

                Spacer(modifier = Modifier.width(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_apple),
                    contentDescription = "Apple Sign In",
                    modifier = Modifier
                        .size(48.dp)
                        .clickable {
                            // Handle Apple sign in
                        }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sign Up Text
            Text(
                text = "You don't have an account? Sign up",
                color = Color.White,
                modifier = Modifier.clickable {
                    // Handle sign up logic here
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ColcheiaappTheme {
        LoginScreen()
    }
}
