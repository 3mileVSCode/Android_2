package com.decinfo.tp1

import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class AfficherChansons : AppCompatActivity() {
    lateinit var liste: ListView
    lateinit var listeChansons : ListeChansons
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
        val queue = Volley.newRequestQueue(this)
        val url = "https://itunes.apple.com/lookup?id=1109714933&entity=song"

        fun decomposerReponse () {
            val remplir = ArrayList<HashMap<String, Any>>()

            listeChansons.results.forEach { chanson ->
                val temp = HashMap<String, Any>()
                temp.put("name", chanson.trackName)
                temp.put("artist", chanson.artistName)
                //temp.put("cover", chanson.artworkUrl100)
                remplir.add(temp)
            }
            val adapt = SimpleAdapter(
                this,
                remplir,
                R.layout.activity_item_chanson,
                arrayOf("name", "artist"),
                intArrayOf(R.id.titre, R.id.artiste)
            )
            liste.adapter = adapt
        }

    }
}