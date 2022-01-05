package com.example.android_research.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android_research.R
import com.example.android_research.ext.showToast
import kotlinx.android.synthetic.main.fragment_first.*
import java.lang.Exception

class Home3Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home3, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        getData()
        eventHandle()
        super.onActivityCreated(savedInstanceState)
    }

    private fun eventHandle() {
        val controller = findNavController()
        btnClick.setOnClickListener {
//            controller.navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    private fun getData() {
        try {
            val arg: Home3FragmentArgs by navArgs()
            var name = arg.person.userName
            showToast(activity!!, name)
        }catch (ex:Exception){

        }

    }
}