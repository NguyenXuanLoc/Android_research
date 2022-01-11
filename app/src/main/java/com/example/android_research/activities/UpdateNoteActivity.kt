package com.example.android_research.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android_research.NoteApplication
import com.example.android_research.R
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_update_note.*
import javax.inject.Inject

class UpdateNoteActivity : AppCompatActivity() {
    private val TAG = "NOTE_VIEW_MODEL"

    @Inject
    lateinit var noteViewModel: NoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note)

//        val appComponent = DaggerAppComponent.builder().application(application).build()

        val appComponent = (application as NoteApplication).appComponent
        appComponent.inject(this)



        Log.d(TAG, "UpdateNoteActivity: ${noteViewModel.noteRepository} , $noteViewModel")

        val note = intent.getSerializableExtra("UPDATE_NOTE") as Note
        edt_note_title.setText(note.title)
        edt_note_des.setText(note.description)

        btn_update.setOnClickListener {
            note.title = edt_note_title.text.toString()
            note.description = edt_note_des.text.toString()
            noteViewModel.updateNote(note)
            finish()
        }

    }
}