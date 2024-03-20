package com.example.jumping_minds_assignment.domain.usecases.app_entry

import com.example.jumping_minds_assignment.domain.manager.LocalUserManger
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManger: LocalUserManger
){
    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }
}