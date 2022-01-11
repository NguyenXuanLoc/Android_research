package com.example.android_research.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android_research.NoteApplication
import com.example.android_research.R
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_add_note.*
import javax.inject.Inject

class AddNoteActivity : AppCompatActivity() {
    private val TAG = "NOTE_VIEW_MODEL"

    @Inject
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

//        val appComponent = DaggerAppComponent.builder().application(application).build()
        val appComponent = (application as NoteApplication).appComponent
        appComponent.inject(this)


        Log.d(TAG, "AddNoteActivity: ${noteViewModel.noteRepository} , $noteViewModel")

        btn_add.setOnClickListener {
            val note =
                Note(edt_note_title.text.toString(), edt_note_des.text.toString())
            noteViewModel.insertNote(note)
            finish()
        }

    }
}