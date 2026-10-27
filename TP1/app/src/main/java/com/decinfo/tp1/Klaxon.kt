package com.decinfo.tp1

import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Klaxon {
    fun getListeChansons (c: Context) {

        val queue = Volley.newRequestQueue(c)
        val url = ""
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {reponse -> val li: ListeChanson = Klaxon().parse<ListeChanson>(reponse) ?: ListeChanson() },
            {Toast.makeText(c, "ne fonctionne pas", LENGTH_LONG)})


    }

}