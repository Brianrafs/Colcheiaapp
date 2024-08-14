import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.colcheiaapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                placeholder = { Text("example@gmail.com") },
                leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Password Input
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Senha") },
                placeholder = { Text("Digite sua senha") },
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Senha") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Sign In Button
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary, // Cor de fundo do botão
                    contentColor = Color.White // Cor do texto
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(200.dp),
                onClick = {
                    navController.navigate("home")
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

            Row(horizontalArrangement = Arrangement.SpaceEvenly){
                // Sign Up Text
                Text(
                    text = "You don't have an account?",
                    color = Color.White,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Sign up",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("signup")
                        }
                )
            }
        }
    }
}