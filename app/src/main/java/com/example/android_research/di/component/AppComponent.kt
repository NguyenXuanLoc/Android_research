package com.example.android_research.di.component

import android.app.Application
import com.example.android_research.activities.AddNoteActivity
import com.example.android_research.activities.MainActivity
import com.example.android_research.activities.UpdateNoteActivity
import com.example.android_research.di.module.AppModule
import com.example.android_research.activities.LoginActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// config tat ca cac module can thiet, dagger tu generate ra 1 graph chua toan bo thong tin
//Khi muốn add module vào trong gr thì cần add module vào compoment
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {


    // Khai bao funtion get ra subCompoment
    fun getAuthComponentFactory(): AuthComponent.Factory

    //    fun getNoteViewModel(): NoteViewModel
    fun inject(activity: MainActivity)
    fun inject(activity: UpdateNoteActivity)
    fun inject(activity: AddNoteActivity)
    fun inject(activity: LoginActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance //Đưa application vào trong graph(vào trong quá trình khởi tạo)
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}