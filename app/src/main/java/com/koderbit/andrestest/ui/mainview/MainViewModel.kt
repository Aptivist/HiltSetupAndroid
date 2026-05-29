package com.koderbit.andrestest.ui.mainview

import androidx.lifecycle.ViewModel
import com.koderbit.andrestest.domain.LogoutUseCase

class MainViewModel(val logoutUseCase: LogoutUseCase) : ViewModel(){

    fun onLogout(){
        logoutUseCase()
    }
}