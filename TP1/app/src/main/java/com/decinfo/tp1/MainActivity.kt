package com.decinfo.tp1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



    lateinit var rainbows: Button
    lateinit var computer: Button
    lateinit var kid: Button
    var collectionName: String = ""
    var id = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rainbows    = findViewById(R.id.rainbows)
        computer    = findViewById(R.id.computer)
        kid         = findViewById(R.id.kid)

        val ec = Ecouteur()

        rainbows.setOnClickListener(ec)
        computer.setOnClickListener(ec)
        kid.setOnClickListener(ec)

    }

    inner class Ecouteur : View.OnClickListener {
        override fun onClick(v: View?) {
            val i = Intent(this@MainActivity, AfficherChansons::class.java)

            if (v == rainbows){
                id = 1109714933
            }
            else if (v == computer){
                id = 1097861387
            }
            else if (v == kid){
                id = 1097862870
            }
            i.putExtra("albumId", id)
            startActivity(i)
        }
    }
}


