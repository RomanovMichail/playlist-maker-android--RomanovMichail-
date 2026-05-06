package com.example.playlist_maker_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playlist_maker_android.ui.theme.PlaylistmakerandroidTheme
import com.example.playlist_maker_android.ui.utils.ButtonSample
import com.example.playlist_maker_android.ui.utils.IconType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaylistmakerandroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PlaylistHost()
                }
            }
        }
    }
}

@Composable
fun MenuScreen(
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3772E7)) // Using the blue from the snippet
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, start = 16.dp),
            text = stringResource(R.string.app_name),
            fontSize = 22.sp,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            fontFamily = FontFamily.SansSerif
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                ),
        ) {
            Column(
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                ButtonSample(
                    leadingIcon = IconType.PainterIcon(painterResource(R.drawable.baseline_search_24)),
                    trailingIcon = IconType.PainterIcon(painterResource(R.drawable.ic_arrow_forward)),
                    contentDescription = stringResource(R.string.search),
                    onClick = onSearchClick
                )
                ButtonSample(
                    leadingIcon = IconType.PainterIcon(painterResource(R.drawable.library_music)),
                    trailingIcon = IconType.PainterIcon(painterResource(R.drawable.ic_arrow_forward)),
                    contentDescription = stringResource(R.string.playlists),
                    onClick = {}
                )
                ButtonSample(
                    leadingIcon = IconType.PainterIcon(painterResource(R.drawable.favorite_border)),
                    trailingIcon = IconType.PainterIcon(painterResource(R.drawable.ic_arrow_forward)),
                    contentDescription = stringResource(R.string.favorites),
                    onClick = {}
                )
                ButtonSample(
                    leadingIcon = IconType.PainterIcon(painterResource(R.drawable.settings)),
                    trailingIcon = IconType.PainterIcon(painterResource(R.drawable.ic_arrow_forward)),
                    contentDescription = stringResource(R.string.settings),
                    onClick = onSettingsClick
                )
            }
        }
    }
}

@Preview
@Composable
private fun MenuScreenPreview() {
    PlaylistmakerandroidTheme {
        MenuScreen(onSearchClick = { }, onSettingsClick = { })
    }
}
