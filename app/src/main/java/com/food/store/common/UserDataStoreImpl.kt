package com.food.store.common

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class UserDataStoreImpl(private val dataStore: DataStore<Preferences>) : UserDataStore {

    override fun getUserId(): Flow<Int> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map {
            it[USER_ID] ?: 0
        }
    }

    override suspend fun saveUserId(userId: Int) {
        dataStore.edit {
            it[USER_ID] = userId
        }
    }

    override suspend fun deleteUserId() {
        dataStore.edit { pref ->
            pref.remove(USER_ID)
        }
    }

    override fun getUserName(): Flow<String> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map {
            it[USER_NAME] ?: ""
        }
    }

    override suspend fun saveUserName(userName: String) {
        dataStore.edit {
            it[USER_NAME] = userName
        }
    }

    override suspend fun deleteUserName() {
        dataStore.edit { pref ->
            pref.remove(USER_NAME)
        }
    }

    override fun getSession(): Flow<String> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map {
            it[USER_SESSION] ?: ""
        }
    }

    override suspend fun saveSession(userSession: String) {
        dataStore.edit {
            it[USER_SESSION] = userSession
        }
    }

    override suspend fun deleteSession() {
        dataStore.edit { pref ->
            pref.remove(USER_SESSION)
        }
    }

    override fun getUserLoggedIn(): Flow<Boolean> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map {
            it[USER_LOGGEDIN] ?: false
        }
    }

    override suspend fun saveUserLoggedIn(userLoggedIn: Boolean) {
        dataStore.edit {
            it[USER_LOGGEDIN] = userLoggedIn
        }
    }

    override suspend fun deleteUserLoggedIn() {
        dataStore.edit { pref ->
            pref.remove(USER_LOGGEDIN)
        }
    }

}