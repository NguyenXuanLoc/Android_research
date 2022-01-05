package com.example.android_research.ext

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showToast(context: Context, content: Any) {
    if (content is Int) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
    } else Toast.makeText(context, content.toString(), Toast.LENGTH_SHORT).show()

}