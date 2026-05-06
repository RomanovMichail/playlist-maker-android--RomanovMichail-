package com.example.playlist_maker_android.data.network

import com.example.playlist_maker_android.data.dto.TracksSearchRequest
import com.example.playlist_maker_android.data.dto.TracksSearchResponse
import com.example.playlist_maker_android.domain.NetworkClient
import com.example.playlist_maker_android.domain.api.TracksRepository
import com.example.playlist_maker_android.domain.models.Track
import kotlinx.coroutines.delay

class TracksRepositoryImpl(private val networkClient: NetworkClient) : TracksRepository {

    override suspend fun searchTracks(expression: String): List<Track> {
        val response = networkClient.doRequest(TracksSearchRequest(expression))
        delay(1000) // Эмулируем задержку ответа
        return if (response.resultCode == 200 && response is TracksSearchResponse) {
            response.results.map {
                val seconds = it.trackTimeMillis / 1000
                val minutes = seconds / 60
                val trackTime = "%02d:%02d".format(minutes, seconds % 60)
                Track(it.trackName, it.artistName, trackTime)
            }
        } else {
            emptyList()
        }
    }
}
