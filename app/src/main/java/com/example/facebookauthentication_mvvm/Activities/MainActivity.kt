package com.example.facebookauthentication_mvvm.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.facebookauthentication_mvvm.Interface.delegate
import com.example.facebookauthentication_mvvm.R
import com.example.facebookauthentication_mvvm.FacebookViewModel
import com.example.facebookauthentication_mvvm.ViewModels.FacebookViewModelFactory
import com.example.facebookauthentication_mvvm.databinding.ActivityMainBinding
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton

/**
 * Created by Hafiz Fahad Hassan
 */

class MainActivity : AppCompatActivity(), delegate {

    private lateinit var facebookViewModel: FacebookViewModel
    private lateinit var mView: View
    private lateinit var facebookBtn: LoginButton
    private lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        /**
         * Binding layout view to update values when required
         */
        val activityLoginBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        facebookViewModel = ViewModelProvider(this, FacebookViewModelFactory(this, application)).get(
            FacebookViewModel::class.java)
        activityLoginBinding.varLogin = facebookViewModel
        mView = activityLoginBinding.parent
        facebookBtn = activityLoginBinding.loginButton
    }

    override fun onFailed(message: Int) {
        TODO("Not yet implemented")
    }

    override fun onSuccess(response: String) {
        FacebookLogin()
    }

    private fun loginSuccess() {
        /**
         * Update your view / activity
         */
       startActivity(Intent(this, ListViewActivity::class.java))
    }
    private fun FacebookLogin() {

        /**
         * Replace facebook id in strings.xml and add your project hash key on developers console.
         */

        callbackManager = CallbackManager.Factory.create()
        facebookBtn.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult?) {
                /**
                 * Called when facebook login is successful
                 */
                loginSuccess()
            }

            override fun onCancel() {
                Toast.makeText(this@MainActivity, "Cancel", Toast.LENGTH_LONG).show()
            }

            override fun onError(error: FacebookException?) {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG).show()
            }
        })
    }
}
