package com.decinfo.annexe_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var boutonAjouter: Button
    lateinit var boutonAfficher: Button
    lateinit var boutonQuitter: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        boutonAfficher = findViewById(R.id.afficher)
        boutonQuitter = findViewById(R.id.quitter)
        boutonAjouter = findViewById(R.id.ajouter)

        //1 etape
        val ec = Ecouteur()

        //2 etape
        //boutonQuitter.setOnClickListener (ec)
        boutonAjouter.setOnClickListener (ec)
        boutonAfficher.setOnClickListener (ec)

        // autre façon

        // interface fonctionnelle : interface qui n'a qu'une méthode
        // une interface fonctionnelle peut être remplacé par une expression lambda (arrow function)

        // boutonQuitter.setOnClickListener { v -> finish() }
        boutonQuitter.setOnClickListener { finish() }
        // pourquoi il n'y a plus de parenthèses, à cause de la règle du "lambda trailing"

    }

    //3e etape

    inner class Ecouteur : View.OnClickListener
    {
        override fun onClick(v: View?) { //type est View ou null
            if (v == boutonQuitter)
                finish()
            else if ( v == boutonAfficher)
            {
                val i = Intent( this@MainActivity, AfficherActivity::class.java)
                startActivity(i)
            }
            else
            {
                val i = Intent( this@MainActivity, AjouterActivity::class.java)
                startActivity(i)
            }
        }
    }









}