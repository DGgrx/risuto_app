package com.example.jumping_minds_assignment.domain.manager

import kotlinx.coroutines.flow.Flow


interface LocalUserManger {
    suspend fun saveAppEntry()

    fun addAppEntry() : Flow<Boolean>
}