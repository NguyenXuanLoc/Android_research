package com.example.android_research.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android_research.MyApplication
import com.example.android_research.R
import com.example.android_research.di.component.DaggerAppComponent
import com.example.android_research.model.Note
import com.example.android_research.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_update_note.*
import javax.inject.Inject

class UpdateNoteActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    /*   private val noteViewModel: NoteViewModel by lazy {
           ViewModelProvider(
               this,
               NoteViewModel.NoteViewModelFactory(this.application)
           )[NoteViewModel::class.java]
       }*/
    @Inject
    lateinit var notViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note)
        MyApplication.inject(this)
//        initGraphDagger()
        Log.e(
            TAG,
            "initControls:  repository: ${notViewModel.noteRepository}, view model: $notViewModel"
        )
        val note = intent.getSerializableExtra("UPDATE_NOTE") as Note
        edt_note_title.setText(note.title)
        edt_note_des.setText(note.description)

        btn_update.setOnClickListener {
            note.title = edt_note_title.text.toString()
            note.description = edt_note_des.text.toString()
            notViewModel.updateNote(note)
            finish()
        }

    }

    //init appCompoment
    private fun initGraphDagger() {
        var appCompoment = DaggerAppComponent.builder().application(application).build()
        appCompoment.inject(this)
    }

}