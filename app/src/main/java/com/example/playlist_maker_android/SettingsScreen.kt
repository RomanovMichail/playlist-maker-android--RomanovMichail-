package com.example.playlist_maker_android

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import com.example.playlist_maker_android.ui.utils.ButtonSample
import com.example.playlist_maker_android.ui.utils.IconType
import com.example.playlist_maker_android.ui.utils.TopAppButtonBar

@Composable
fun SettingsScreen(onBackClick: () -> Unit) {
   val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            TopAppButtonBar(
                context = context,
                text = stringResource(R.string.settings),
                onClick = onBackClick
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            ButtonSample(
                trailingIcon = IconType.PainterIcon(painterResource(R.drawable.settings)), // Placeholder for theme switch
                contentDescription = stringResource(R.string.dark_theme),
                contentFontSize = 16,
                horizontalPadding = 16,
                verticalPadding = 12
            ) { }
            ButtonSample(
                trailingIcon = IconType.ImageVectorIcon(Icons.Default.Share),
                contentDescription = stringResource(R.string.share_app),
                contentFontSize = 16,
                horizontalPadding = 16,
                verticalPadding = 12
            ) {
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    putExtra(Intent.EXTRA_TEXT, context.getString(R.string.share_app_text))
                    type = "text/plain"
                }
                context.startActivity(Intent.createChooser(shareIntent, null))
            }
            ButtonSample(
                trailingIcon = IconType.PainterIcon(painterResource(R.drawable.support)),
                contentDescription = stringResource(R.string.contact_support),
                contentFontSize = 16,
                horizontalPadding = 16,
                verticalPadding = 12
            ) {
                val supportMessageIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = "mailto:".toUri()
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(context.getString(R.string.support_email)))
                    putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.email_subject))
                    putExtra(Intent.EXTRA_TEXT, context.getString(R.string.email_body))
                }
                context.startActivity(supportMessageIntent)
            }
            ButtonSample(
                trailingIcon = IconType.PainterIcon(painterResource(R.drawable.ic_arrow_forward)),
                contentDescription = stringResource(R.string.user_agreement),
                contentFontSize = 16,
                horizontalPadding = 16,
                verticalPadding = 12
            ) {
                val userAgreementIntent = Intent(Intent.ACTION_VIEW).apply {
                    data = context.getString(R.string.terms_url).toUri()
                }
                context.startActivity(userAgreementIntent)
            }
        }
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    SettingsScreen(onBackClick = { })
}
