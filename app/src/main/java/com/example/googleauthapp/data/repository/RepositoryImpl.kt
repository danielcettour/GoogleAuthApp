package com.example.googleauthapp.data.repository

// import com.example.googleauthapp.data.remote.KtorApi
import com.example.googleauthapp.domain.model.ApiRequest
// import com.example.googleauthapp.domain.model.ApiResponse
// import com.example.googleauthapp.domain.model.UserUpdate
import com.example.googleauthapp.domain.repository.DataStoreOperations
import com.example.googleauthapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * RepositoryImpl implements Repository
 * (DataStoreOperationsImpl implements DataStoreOperations)
 * we inject the interface DataStoreOperations, but not implement it (like in DataStoreOperationsImpl)
 *
 * we'll create a Dagger/Hilt module later to provide the interface,
 * but instead of providing the interface, we'll provide its implementation
 *
 * later, this RepositoryImpl will be injected into a viewmodel
 */
class RepositoryImpl @Inject constructor(
    private val dataStoreOperations: DataStoreOperations,
    //   private val ktorApi: KtorApi
) : Repository {

    // either if we implement the interface, or inject it, we'll have to override the methods
    override suspend fun saveSignedInState(signedIn: Boolean) {
        dataStoreOperations.saveSignedInState(signedIn = signedIn)
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStoreOperations.readSignedInState()
    }

    /*override suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse {
        return try {
            ktorApi.verifyTokenOnBackend(request = request)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun getUserInfo(): ApiResponse {
        return try {
            ktorApi.getUserInfo()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun updateUser(userUpdate: UserUpdate): ApiResponse {
        return try {
            ktorApi.updateUser(userUpdate = userUpdate)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun deleteUser(): ApiResponse {
        return try {
            ktorApi.deleteUser()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun clearSession(): ApiResponse {
        return try {
            ktorApi.clearSession()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }*/
}