package com.example.facebookauthentication_mvvm.Models
/**
 * Created by Hafiz Fahad Hassan
 */

data class FacebookLoginModel(var email : String, var pass: String) {
    override fun toString(): String {
        return "FacebookLoginModel(email='$email', pass='$pass')"
    }
}