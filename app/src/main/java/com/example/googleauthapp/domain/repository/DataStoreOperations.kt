package com.example.googleauthapp.domain.repository

import kotlinx.coroutines.flow.Flow

/**
 * when Google button is pressed
 */
interface DataStoreOperations {
    suspend fun saveSignedInState(signedIn: Boolean)
    fun readSignedInState(): Flow<Boolean> // not suspend, Flow is asynchronous by default
}