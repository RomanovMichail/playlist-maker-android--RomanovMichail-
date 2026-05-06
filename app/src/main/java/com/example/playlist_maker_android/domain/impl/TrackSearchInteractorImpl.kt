package com.example.playlist_maker_android.domain.impl

import com.example.playlist_maker_android.domain.api.TrackSearchInteractor
import com.example.playlist_maker_android.domain.api.TracksRepository
import com.example.playlist_maker_android.domain.models.Track

class TrackSearchInteractorImpl(private val repository: TracksRepository) : TrackSearchInteractor {
    override suspend fun searchTracks(expression: String): List<Track> {
        return repository.searchTracks(expression)
    }
}
