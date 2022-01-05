package com.example.android_research

import addToCompositeDisposable
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.android_research.ext.showToast
import com.example.android_research.room.AppDataBase
import com.example.android_research.room.UserModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val db by lazy {
        AppDataBase.getInstance(this)
    }
    private val compositeDisposable by lazy { CompositeDisposable() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSize()
        eventHandle()
    }

    @SuppressLint("CheckResult")
    fun getSize() {
        db.userDao().getAll().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                showToast(this, "SIZE: ${it.size}")
            }, {
                showToast(this, it.localizedMessage)
            }).addToCompositeDisposable(compositeDisposable = compositeDisposable)
    }

    var i = 0
    private fun insertTest() {
        db.userDao().insert(UserModel(id = 0, userName = "A $i", add = "H $i"))
        i++
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    private fun eventHandle() {
        lblClick.setOnClickListener {
            insertTest()
            getSize()
        }
    }
}