package com.example.android_research.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_research.MyApplication
import com.example.android_research.R
import com.example.android_research.di.component.DaggerAppComponent
import com.example.android_research.model.Note
import com.example.android_research.viewmodel.NoteViewModel
import com.example.noteapp.adapter.NoteAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    /*    private val noteViewModel: NoteViewModel by lazy {
            ViewModelProvider(
                this,
                NoteViewModel.NoteViewModelFactory(this.application)
            )[NoteViewModel::class.java]
        }*/
    @Inject
    lateinit var notViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        initGraphDagger()
        MyApplication.inject(this)
        initControls()
        initEvents()
    }

    //init appCompoment
    private fun initGraphDagger() {
        var appCompoment = DaggerAppComponent.builder().application(application).build()
        appCompoment.inject(this)
    }

    private fun initEvents() {
        btn_open_add_activity.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initControls() {
        val adapter = NoteAdapter(this@MainActivity, onItemClick, onItemDelete)
        rv_note.setHasFixedSize(true)
        rv_note.layoutManager = LinearLayoutManager(this)
        rv_note.adapter = adapter
        Log.e(
            TAG,
            "initControls:  repository: ${notViewModel.noteRepository}, view model: $notViewModel"
        )
        notViewModel.getAllNote().observe(this) {
            adapter.setNotes(it)
        }
    }

    private val onItemClick: (Note) -> Unit = {
        val intent = Intent(this, UpdateNoteActivity::class.java)
        intent.putExtra("UPDATE_NOTE", it)
        startActivity(intent)

    }
    private val onItemDelete: (Note) -> Unit = {
//        noteViewModel.deleteNote(it)
    }
}