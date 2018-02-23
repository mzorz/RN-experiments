package com.example.mariozorz.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ChooserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chooser)

        val nativeButton = findViewById<Button>(R.id.native_activity)
        nativeButton.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        val intent = Intent(this@ChooserActivity, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
        )

        val reactNativeButton = findViewById<Button>(R.id.react_activity)
        reactNativeButton.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        val intent = Intent(this@ChooserActivity, MyReactActivity::class.java)
                        startActivity(intent)
                    }
                }
        )

    }
}
