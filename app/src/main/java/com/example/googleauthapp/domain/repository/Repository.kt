package com.example.googleauthapp.domain.repository

import com.example.googleauthapp.domain.model.ApiRequest
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun saveSignedInState(signedIn: Boolean)
    fun readSignedInState(): Flow<Boolean>
    // suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse
    // suspend fun getUserInfo(): ApiResponse
    // suspend fun updateUser(userUpdate: UserUpdate): ApiResponse
    // suspend fun deleteUser(): ApiResponse
    // suspend fun clearSession(): ApiResponse
}