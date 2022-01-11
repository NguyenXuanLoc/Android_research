package com.example.android_research.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android_research.NoteApplication
import com.example.android_research.R
import com.example.noteapp.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    private val TAG = "LoginActivityTAG"

    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val authComponent =
            (application as NoteApplication).appComponent.getAuthComponentFactory().create()

        authComponent.inject(this)

        Log.d(TAG, "LoginActivity $loginViewModel")

        btn_login.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
            finish()
        }
    }
}