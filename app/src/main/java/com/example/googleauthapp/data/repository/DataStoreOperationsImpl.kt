package com.example.googleauthapp.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.example.googleauthapp.domain.repository.DataStoreOperations
import com.example.googleauthapp.util.Constants.PREFERENCES_SIGNED_IN_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import androidx.datastore.preferences.core.*

/**
 * DataStoreOperationsImpl implements DataStoreOperations
 * (RepositoryImpl implements Repository, injects DataStoreOperations)
 * read or save value signedInKey, to check if we are logged or not
 */
class DataStoreOperationsImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreOperations { // implements DataStoreOperations, is our interface

    private object PreferencesKey {
        val signedInKey = booleanPreferencesKey(name = PREFERENCES_SIGNED_IN_KEY)
    }

    override suspend fun saveSignedInState(signedIn: Boolean) {
        // dataStore is the instance injected
        dataStore.edit { preferences ->
            preferences[PreferencesKey.signedInKey] = signedIn // we persist the value (boolean) in the dataStore
        }
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception -> // catch without try
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val signedInState = preferences[PreferencesKey.signedInKey] ?: false
                signedInState
            }
    }
}