package com.example.playlist_maker_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.playlist_maker_android.ui.theme.PlaylistmakerandroidTheme

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaylistmakerandroidTheme {
                Text("Экран настроек")
            }
        }
    }
}
