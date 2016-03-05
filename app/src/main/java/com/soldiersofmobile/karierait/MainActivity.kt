package com.soldiersofmobile.karierait

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.button
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.toast

import java.util.HashMap

internal class LoginManager {

    var username: String? = null
    var password: String? = null

    private val users = mapOf("test" to "test", "user" to "password")

    fun login(username: String, password: String) {
        this.username = username
        this.password = password

        Log.d("LoginManager", "Trying to login username:$username password:$password")

        for ((u, p) in users) {
            if (username == u && password == p) {
                Log.d("LoginManager", "Logged:" + toString())
            }
        }

    }

    override fun toString(): String {
        return "LoginManager{username='$username\', password='$password\'}"
    }
}

class MainActivity : AppCompatActivity() {


    private val loginManager = LoginManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        signInButton.setOnClickListener {
            loginManager.login(usernameEditText.text.toString(), passwordEditText.text.toString())
            toast("test")

            startActivity(intentFor<DynamicActivity>("extraValue" to 2))

        }

    }
}
