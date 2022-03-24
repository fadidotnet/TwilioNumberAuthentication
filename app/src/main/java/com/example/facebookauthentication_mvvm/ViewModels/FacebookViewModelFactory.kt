package com.example.facebookauthentication_mvvm.ViewModels

import android.app.Application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.facebookauthentication_mvvm.FacebookViewModel
import com.example.facebookauthentication_mvvm.Interface.delegate

/**
 * Created by Hafiz Fahad Hassan
 */
@Suppress("UNCHECKED_CAST")
class FacebookViewModelFactory(private val loginDelegate: delegate, private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FacebookViewModel(loginDelegate, mApplication) as T
    }
}