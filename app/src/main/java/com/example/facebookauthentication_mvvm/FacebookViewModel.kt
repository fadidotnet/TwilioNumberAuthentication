package com.example.facebookauthentication_mvvm

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import com.example.facebookauthentication_mvvm.Utils.Constants
import com.example.facebookauthentication_mvvm.Models.FacebookLoginModel
import com.example.facebookauthentication_mvvm.Interface.delegate

/**
 * Created by Hafiz Fahad Hassan
 */

@Suppress("JoinDeclarationAndAssignment", "UNUSED_PARAMETER")
class FacebookViewModel( var loginDelegate: delegate, mApplication: Application) : AndroidViewModel(mApplication) {

     var facebookLoginModel: FacebookLoginModel

    init {
        this.facebookLoginModel = FacebookLoginModel("", "")
    }

    fun facebookBtnClicked(view: View) {
        loginDelegate.onSuccess(Constants.FACEBOOK_CLICKED)
    }



}