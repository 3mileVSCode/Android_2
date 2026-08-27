package com.decinfo.annexe_1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class AfficherActivity : AppCompatActivity() {
    lateinit var liste: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_afficher)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        liste = findViewById(R.id.list)
        liste.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lireMemo())

    }

    fun lireMemo() : ArrayList<String> {
        val fis = openFileInput("memo.txt")
        val isr = InputStreamReader(fis)
        val br = BufferedReader(isr)
        val al = ArrayList<String>()

        // fonction de haut niveau, un seul parametre qui est une lambda donc pas besoin de ()
        br.use {
            while (br.readLine() != null) {
                al.add(br.readLine())
            }
            //br.forEachLine { ligne -> al.add(ligne) }
            //al = br.readLines() as ArrayList<String>

            return al
        }
    }

}