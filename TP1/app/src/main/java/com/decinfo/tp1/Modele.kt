package com.decinfo.tp1

import android.R
import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.beust.klaxon.Klaxon

class Modele {
    fun getListeChansons (c: Context) {

        val queue = Volley.newRequestQueue(c)
        val url = "https://itunes.apple.com/lookup?id=1109714933&entity=song"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {reponse -> val li: ListeChansons = Klaxon().parse<ListeChansons>(reponse) ?: ListeChansons() },
            {Toast.makeText(c, "ne fonctionne pas", LENGTH_LONG)})
        queue.add(stringRequest)
    }



}