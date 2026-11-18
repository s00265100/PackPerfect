
package com.example.packperfect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.packperfect.ui.theme.PackPerfectTheme

// This is the main activity of my PackPerfect app.
// It starts the app and displays the home screen.
class MainActivity : ComponentActivity() {

    // This function runs when my app is opened.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Allows my app to draw behind the system bars.
        enableEdgeToEdge()

        // Sets up the user interface using Jetpack Compose.
        setContent {
            PackPerfectTheme {

                // Scaffold provides the basic screen layout.
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    // Displays my home screen with the correct padding.
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// This function displays the main home screen of my app.
// It shows the app name, trip information and Add Trip button.
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    // Column arranges all my screen content vertically.
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Displays the name of my app.
        Text(
            text = "PackPerfect",
            style = MaterialTheme.typography.headlineLarge
        )

        // Displays a short description of my app.
        Text(
            text = "Your Smart Travel Packing Planner"
        )

        // Adds space between the title and trips section.
        Spacer(modifier = Modifier.height(24.dp))

        // Displays the heading for my saved trips.
        Text(
            text = "My Trips",
            style = MaterialTheme.typography.titleLarge
        )

        // Adds space before the trip card.
        Spacer(modifier = Modifier.height(16.dp))

        // Calls my TripCard function to display a sample trip.
        TripCard()

        // Adds space between the trip card and button.
        Spacer(modifier = Modifier.height(24.dp))

        // Displays a button for adding a new trip.
        // I will add the button functionality later.
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Trip")
        }
    }
}

// This function displays information about a trip.
// I can reuse this card when I add more trips later.
@Composable
fun TripCard() {

    // Card creates a Material Design container.
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        // Column arranges the trip information vertically.
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            // Displays the sample trip name.
            Text(
                text = "Paris Holiday",
                style = MaterialTheme.typography.titleMedium
            )

            // Adds space between the trip name and dates.
            Spacer(modifier = Modifier.height(8.dp))

            // Displays the sample travel dates.
            Text(text = "12 - 18 December 2026")

            // Adds space before the packing progress.
            Spacer(modifier = Modifier.height(8.dp))

            // Displays the current sample packing progress.
            Text(text = "Packing progress: 0%")
        }
    }
}

// This function lets me preview my home screen
// in Android Studio without running an emulator.
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    // Applies my app theme to the preview.
    PackPerfectTheme {

        // Displays my home screen in the preview.
        HomeScreen()
    }
}
