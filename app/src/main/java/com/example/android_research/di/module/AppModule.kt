package com.example.android_research.di.module

import android.app.Application
import com.example.android_research.database.NoteDatabase
import com.example.android_research.database.dao.NoteDao
import com.example.android_research.di.component.AuthComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//Là nơi khai báo cho dagger biết cách khởi tạo các đối tượng như thế nào
//subComponents: Khai baso AuthComponent laf subComponent cua AppComponent
@Module(subcomponents = [AuthComponent::class])
class AppModule {

    @Singleton
    @Provides
    fun provideNoteDataBase(application: Application): NoteDatabase {
        return NoteDatabase.getInstance(application)
    }

    @Singleton
    @Provides
    fun provideNoteDao(notDataBase: NoteDatabase): NoteDao {
        return notDataBase.getNoteDao()
    }
}