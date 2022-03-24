package com.example.facebookauthentication_mvvm.Interface
/**
 * Created by Hafiz Fahad Hassan
 */
interface delegate {
    /**
     * Interface required for callback
     */

    fun onFailed(message: Int)

    fun onSuccess(response: String)
}