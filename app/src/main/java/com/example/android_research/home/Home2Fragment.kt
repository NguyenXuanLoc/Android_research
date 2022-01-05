package com.example.android_research.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android_research.R
import com.example.android_research.ext.showToast
import com.example.android_research.model.Person
import kotlinx.android.synthetic.main.fragment_first.*

class Home2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        eventHandle()
        super.onActivityCreated(savedInstanceState)
    }

    private fun eventHandle() {
        var data = arguments
        var value = data?.getInt("test1")
        value?.let {
            showToast(activity!!, value.toString())
        }
        val controller = findNavController()
        btnClick.setOnClickListener {
            // Navigator normal
//            controller.navigate(R.id.action_home2Fragment_to_home3Fragment)
            // navigator use Safe arg and sent data
            sendDataUseSafeArg()
        }
    }

    private fun sendDataUseSafeArg() {
        var person = Person(userName = "Test", age = 1)
        var action = Home2FragmentDirections.actionHome2FragmentToHome3Fragment(person = person)
        findNavController().navigate(action)
    }
}