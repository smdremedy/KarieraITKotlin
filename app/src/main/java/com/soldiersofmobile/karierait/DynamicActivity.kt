package com.soldiersofmobile.karierait

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.button
import org.jetbrains.anko.linearLayout

class DynamicActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            button(text = "It's alive")
        }
    }
}