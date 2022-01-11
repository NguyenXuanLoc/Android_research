package com.example.android_research.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android_research.MyApplication
import com.example.android_research.R
import com.example.android_research.viewmodel.LoginViewModel
import com.example.android_research.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    private var TAG = "MainActivity"

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        MyApplication.inject(this)
        var authComponent = MyApplication.component.getAuthComponentFactory().create()
        authComponent.inject(this)
        Log.e(TAG, "onCreate: $viewModel")
        btn_login.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
            finish()
        }
    }


}