package com.example.fragmentdatatransfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import kotlinx.coroutines.*
import kotlin.concurrent.fixedRateTimer
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class FirstFrangment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var button = view?.findViewById<Button>(R.id.button)

        return inflater.inflate(R.layout.fragment_first_frangment, container, false)
    }


    }
