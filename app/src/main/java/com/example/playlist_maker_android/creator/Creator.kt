package com.example.playlist_maker_android.creator

import com.example.playlist_maker_android.data.network.RetrofitNetworkClient
import com.example.playlist_maker_android.data.network.TracksRepositoryImpl
import com.example.playlist_maker_android.domain.api.TrackSearchInteractor
import com.example.playlist_maker_android.domain.api.TracksRepository
import com.example.playlist_maker_android.domain.impl.TrackSearchInteractorImpl

object Creator {
    fun getTracksRepository(): TracksRepository {
        return TracksRepositoryImpl(RetrofitNetworkClient(Storage()))
    }

    fun provideTrackSearchInteractor(): TrackSearchInteractor {
        return TrackSearchInteractorImpl(getTracksRepository())
    }
}
