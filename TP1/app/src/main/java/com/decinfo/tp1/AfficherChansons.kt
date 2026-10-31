package com.decinfo.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AfficherChansons : AppCompatActivity(), Observateur {
    lateinit var liste: ListView
    val data = ArrayList<HashMap<String, Any>>()
    var idAlbum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_afficher_chansons)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        liste = findViewById(R.id.liste)
        idAlbum = intent.getIntExtra("albumId", 0)
        afficher()
    }

    fun afficher() {

        Modele.listeChansons.results.forEach { chanson ->
            val temp = HashMap<String, Any>()
            temp.put("name", chanson.trackName)
            temp.put("artist", chanson.artistName)
            //temp.put("cover", chanson.artworkUrl100)
            data.add(temp)
        }
        val adapt = SimpleAdapter(
            this,
            data,
            R.layout.activity_item_chanson,
            arrayOf("name", "artist"),
            intArrayOf(R.id.titre, R.id.artiste)
        )
        liste.adapter = adapt
    }

    override fun actualiser() {
        TODO("Not yet implemented")
    }

}