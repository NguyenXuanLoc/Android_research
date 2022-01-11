package com.example.android_research

import android.app.Application
import com.example.android_research.activities.AddNoteActivity
import com.example.android_research.activities.LoginActivity
import com.example.android_research.activities.MainActivity
import com.example.android_research.activities.UpdateNoteActivity
import com.example.noteapp.di.AppComponent
import com.example.noteapp.di.DaggerAppComponent

class MyApplication : Application() {
    companion object {
        lateinit var component: AppComponent
        fun inject(activity: MainActivity) {
//            component.inject(activity)
        }

        fun inject(activity: AddNoteActivity) {
//            component.inject(activity)
        }

        fun inject(activity: UpdateNoteActivity) {
//            component.inject(activity)
        }

        //InjectSubCompoment
        fun inject(activity: LoginActivity) {
//            component.getAuthComponentFactory().create().inject(activity)
        }
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().application(this).build()
    }
}