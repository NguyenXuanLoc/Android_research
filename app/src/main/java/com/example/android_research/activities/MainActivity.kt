package com.example.android_research.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_research.NoteApplication
import com.example.android_research.R
import com.example.android_research.adapter.NoteAdapter
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private val TAG = "NOTE_VIEW_MODEL"

    @Inject
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val appComponent = DaggerAppComponent.builder().application(application).build()
        val appComponent = (application as NoteApplication).appComponent
        appComponent.inject(this)

        Log.d(TAG, "MainActivity: ${noteViewModel.noteRepository} , $noteViewModel")

        initControls()
        initEvents()
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

        noteViewModel.getAllNote().observe(this, {
            adapter.setNotes(it)
        })

    }

    private val onItemClick: (Note) -> Unit = {
        val intent = Intent(this, UpdateNoteActivity::class.java)
        intent.putExtra("UPDATE_NOTE", it)
        startActivity(intent)

    }
    private val onItemDelete: (Note) -> Unit = {
        noteViewModel.deleteNote(it)
    }
}