package com.example.playlist_maker_android.domain.api

import com.example.playlist_maker_android.domain.models.Track

interface TracksRepository {
    suspend fun searchTracks(expression: String): List<Track>
}
