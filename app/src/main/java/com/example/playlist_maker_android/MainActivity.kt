package com.example.playlist_maker_android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playlist_maker_android.ui.theme.PlaylistmakerandroidTheme
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.clip

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaylistmakerandroidTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()                    // занимаем весь экран
            .background(Color(0xFFF5F5F5))    // общий фон
            .padding(horizontal = 24.dp, vertical = 40.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(Color(0xFF3369FF))
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Playlist maker",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp)
        ) {
            MenuItem(
                title = "Поиск",
                iconRes = R.drawable.baseline_search_24
            ) {
                val intent = Intent(context, SearchActivity::class.java)
                context.startActivity(intent)
            }

            MenuItem(
                title = "Плейлисты",
                iconRes = R.drawable.library_music
            ) {
                Toast.makeText(context, "Плейлисты пока не реализованы", Toast.LENGTH_SHORT).show()
            }

            MenuItem(
                title = "Избранное",
                iconRes = R.drawable.favorite_border
            ) {
                Toast.makeText(context, "Избранное пока не реализовано", Toast.LENGTH_SHORT).show()
            }

            MenuItem(
                title = "Настройки",
                iconRes = R.drawable.settings
            ) {
                val intent = Intent(context, SettingsActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}


@Composable
fun MenuItem(
    title: String,
    iconRes: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "›",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFFB0B0B0)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    PlaylistmakerandroidTheme {
        MainScreen()
    }
}
