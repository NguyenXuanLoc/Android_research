package com.example.android_research.viewmodel

import androidx.lifecycle.LiveData
import com.example.android_research.database.repository.NoteRepository
import com.example.android_research.model.Note
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

// khai bao cach khoi tao 1 doi tuong inject tu dagger
@Singleton
class NoteViewModel @Inject constructor(val noteRepository: NoteRepository) {


    fun insertNote(note: Note) = GlobalScope.launch {
        noteRepository.insertNote(note)
    }

    fun updateNote(note: Note) = GlobalScope.launch {
        noteRepository.updateNote(note)
    }

    fun deleteNote(note: Note) = GlobalScope.launch {
        noteRepository.deleteNote(note)
    }

    fun getAllNote(): LiveData<List<Note>> = noteRepository.getAllNote()
/*
    class NoteViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return NoteViewModel(application) as T
            }

            throw IllegalArgumentException("Unable construct viewModel")
        }

    }*/


}