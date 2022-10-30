package com.example.testapp.createRequestScreen

import com.example.testapp.createRequestScreen.presentation.CreateRequestFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun getCreateRequestScreen() = FragmentScreen { CreateRequestFragment.newInstance() }