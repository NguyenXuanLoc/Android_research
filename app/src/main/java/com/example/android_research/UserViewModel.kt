package com.example.android_research

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_research.model.UserModel

class UserViewModel : ViewModel() {
    private var mListUserLiveData: MutableLiveData<ArrayList<UserModel>> = MutableLiveData()
    private var mListUser: ArrayList<UserModel> = ArrayList()

    init {
        mListUser.addAll(fakeData())
        mListUserLiveData.value = mListUser
    }

    fun getmListUserLiveData(): MutableLiveData<ArrayList<UserModel>> {
        return mListUserLiveData
    }

    fun addUser(user: UserModel) {
        mListUser.add(user)
        mListUserLiveData.value = mListUser
    }

    private fun fakeData(): ArrayList<UserModel> {
        var list = ArrayList<UserModel>()
        list.add(UserModel("A", "A+"))
        list.add(UserModel("B", "B+"))
        list.add(UserModel("C", "C+"))
        list.add(UserModel("D", "D+"))
        list.add(UserModel("E", "E+"))
        return list
    }
}