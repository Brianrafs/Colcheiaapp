import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavHostController) {
    // States for the input fields
    var name by remember { mutableStateOf("") }
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
            // Header Text
            Text(
                text = "Create Account",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White,
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Name Input
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Full name") },
                placeholder = { Text("Enter your full name") },
                leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

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
                label = { Text("Password") },
                placeholder = { Text("Enter your password") },
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
                    navController.navigate("login")
                }) {
                Text("Sign up")
            }

        }
    }
}