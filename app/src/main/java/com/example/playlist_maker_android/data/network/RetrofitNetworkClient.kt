package com.example.playlist_maker_android.data.network

import com.example.playlist_maker_android.creator.Storage
import com.example.playlist_maker_android.data.dto.BaseResponse
import com.example.playlist_maker_android.data.dto.TracksSearchRequest
import com.example.playlist_maker_android.data.dto.TracksSearchResponse
import com.example.playlist_maker_android.domain.NetworkClient

class RetrofitNetworkClient(private val storage: Storage) : NetworkClient {

    override fun doRequest(dto: Any): BaseResponse {
        if (dto is TracksSearchRequest) {
            val searchList = storage.search(dto.expression)
            return TracksSearchResponse(searchList).apply { resultCode = 200 }
        } else {
            return BaseResponse().apply { resultCode = 400 }
        }
    }
}
