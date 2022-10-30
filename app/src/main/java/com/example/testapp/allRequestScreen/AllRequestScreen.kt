package com.example.testapp.allRequestScreen

import com.example.testapp.allRequestScreen.presentation.AllRequestFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun getAllRequestScreen() = FragmentScreen { AllRequestFragment.newInstance() }