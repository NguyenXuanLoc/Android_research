package com.example.android_research.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.android_research.R
import kotlinx.android.synthetic.main.fragment_first.*

class Home1Fragment : Fragment() {
    private lateinit var controller: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        eventHandle()
        super.onActivityCreated(savedInstanceState)
    }

    private fun eventHandle() {
        controller = findNavController()
        btnClick.setOnClickListener {
            controller.navigate(R.id.action_home1Fragment_to_home2Fragment)
        }
    }
}