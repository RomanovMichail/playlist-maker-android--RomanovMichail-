package com.example.playlist_maker_android

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onBackClick: () -> Unit = {}
) {
    val context = LocalContext.current

    val shareAppTitle = stringResource(R.string.share_app)
    val shareAppText = stringResource(R.string.share_app_text)

    val contactSupportTitle = stringResource(R.string.contact_support)
    val supportEmail = stringResource(R.string.support_email)
    val emailSubject = stringResource(R.string.email_subject)
    val emailBody = stringResource(R.string.email_body)

    val userAgreementTitle = stringResource(R.string.user_agreement)
    val termsUrl = stringResource(R.string.terms_url)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Настройки") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            SettingsItem(
                title = shareAppTitle,
                iconResId = R.drawable.share
            ) {
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, shareAppText)
                }
                context.startActivity(Intent.createChooser(shareIntent, null))
            }

            SettingsItem(
                title = contactSupportTitle,
                iconResId = R.drawable.support
            ) {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(supportEmail))
                    putExtra(Intent.EXTRA_SUBJECT, emailSubject)
                    putExtra(Intent.EXTRA_TEXT, emailBody)
                }
                context.startActivity(Intent.createChooser(emailIntent, null))
            }

            SettingsItem(
                title = userAgreementTitle,
                iconResId = R.drawable.ic_arrow_forward
            ) {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(termsUrl))
                context.startActivity(browserIntent)
            }
        }
    }
}

@Composable
fun SettingsItem(
    title: String,
    iconResId: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}
