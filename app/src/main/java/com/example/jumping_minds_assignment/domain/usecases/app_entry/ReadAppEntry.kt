package com.example.jumping_minds_assignment.domain.usecases.app_entry

import com.example.jumping_minds_assignment.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (
    private val localUserManger: LocalUserManger
){
     operator fun invoke(): Flow<Boolean> {
        return localUserManger.addAppEntry()
    }
}