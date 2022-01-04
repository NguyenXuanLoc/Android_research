package com.example.android_research.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android_research.R
import kotlinx.android.synthetic.main.fragment_first.*

class More3Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_more3, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        eventHandle()
        super.onActivityCreated(savedInstanceState)
    }

    private fun eventHandle() {
        val controller = findNavController()
    }
}