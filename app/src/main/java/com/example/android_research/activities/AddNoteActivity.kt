package com.example.android_research.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android_research.MyApplication
import com.example.android_research.R
import com.example.android_research.di.component.DaggerAppComponent
import com.example.android_research.model.Note
import com.example.android_research.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_add_note.*
import javax.inject.Inject

class AddNoteActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    /*  private val noteViewModel: NoteViewModel by lazy {
          ViewModelProvider(
              this,
              NoteViewModel.NoteViewModelFactory(this.application)
          )[NoteViewModel::class.java]
      }*/
    @Inject
    lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
//        initGraphDagger()
        MyApplication.inject(this)
        Log.e(
            TAG,
            "initControls:  repository: ${noteViewModel.noteRepository}, view model: $noteViewModel"
        )
        btn_add.setOnClickListener {
            val note =
                Note(edt_note_title.text.toString(), edt_note_des.text.toString())
            noteViewModel.insertNote(note)
        }

    }

    //init appCompoment
    private fun initGraphDagger() {
        var appCompoment = DaggerAppComponent.builder().application(application).build()
        appCompoment.inject(this)
    }

}