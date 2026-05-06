package com.example.playlist_maker_android.domain.api

import com.example.playlist_maker_android.domain.models.Track

interface TrackSearchInteractor {
    suspend fun searchTracks(expression: String): List<Track>
}
