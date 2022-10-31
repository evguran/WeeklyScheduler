package com.example.tablayouttest

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showToast() {
    Toast.makeText(this, "I am a toast", Toast.LENGTH_LONG).show()
}