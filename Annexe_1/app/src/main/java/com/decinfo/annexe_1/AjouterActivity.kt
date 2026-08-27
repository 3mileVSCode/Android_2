package com.decinfo.annexe_1

import android.hardware.biometrics.PromptContentItemPlainText
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedWriter
import java.io.OutputStreamWriter

class AjouterActivity : AppCompatActivity() {
    lateinit var boutonMemo : Button
    lateinit var memo : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ajouter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        boutonMemo = findViewById(R.id.boutonMemo)
        memo = findViewById(R.id.memo)

        boutonMemo.setOnClickListener {
            // lorsqu'on clique sur le bouton
            var texteMemo = memo.text.toString()

            val fos = openFileOutput("memo.txt", MODE_APPEND) // Append pour qu'il écrive à la fin du fichier
            val osw = OutputStreamWriter (fos)
            val bw = BufferedWriter(osw)

            bw.use {
                bw.write(texteMemo)
                bw.newLine()
                finish()
            }
            

        }
    }
}