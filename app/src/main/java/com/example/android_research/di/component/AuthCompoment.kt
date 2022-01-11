package com.example.android_research.di.component

import com.example.android_research.activities.LoginActivity
import com.example.android_research.di.annotation.Auth
import com.example.android_research.viewmodel.LoginViewModel
import dagger.Subcomponent
import javax.inject.Singleton

@Auth// Đánh dấu AuthComponent có phạm vi ảnh hưởng trong Auth Anotation
@Subcomponent
interface AuthComponent {

    fun getLoginViewModel(): LoginViewModel

    fun inject(activity: LoginActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthComponent
    }
}