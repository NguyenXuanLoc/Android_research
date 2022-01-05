package com.example.android_research

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_research.model.UserModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var list = ArrayList<UserModel>()
    private val userViewModel: UserViewModel by lazy { ViewModelProvider(this).get(UserViewModel::class.java) }
    private val adapter by lazy {
        UserAdapter(this, list) { it ->
            Toast.makeText(this, it.userName, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWidget()
        eventHandle()
    }

    private fun initWidget() {
        var layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rclUser.adapter = adapter
        rclUser.layoutManager = layoutManager
    }

    var index = 0
    private fun eventHandle() {
        btnAddUser.setOnClickListener {
            userViewModel.addUser(UserModel("A $index", "B $index"))
            index++
        }
        userViewModel.getmListUserLiveData().observe(this, Observer {
            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }
}