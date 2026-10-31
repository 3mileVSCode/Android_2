package com.decinfo.tp1

import android.R
import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.beust.klaxon.Klaxon

object Modele : Sujet {
    val observateurs = ArrayList<Observateur>()
    var listeChansons = ListeChansons()

    fun chargerChansons(c: Context , albumID : Int) {
        val queue = Volley.newRequestQueue(c)
        val url = "https://itunes.apple.com/lookup?id=$albumID&entity=song"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { reponse ->
                listeChansons = Klaxon().parse<ListeChansons>(reponse) ?: ListeChansons()
                avertirObservateur()
            },
            {
                println("Erreur chargerChansons : ne fonctionne pas")
            }
        )
        queue.add(stringRequest)
    }

    override fun ajouterObservateur(o: Observateur) {
        observateurs.add(o)
    }

    override fun retirerObservateur(o: Observateur) {
        observateurs.remove(o)
    }

    override fun avertirObservateur() {
        for (o in observateurs) {
            o.actualiser()
        }
    }
}