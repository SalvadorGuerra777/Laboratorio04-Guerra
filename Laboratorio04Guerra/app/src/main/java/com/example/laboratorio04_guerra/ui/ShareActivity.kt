package com.example.laboratorio04_guerra.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.laboratorio04_guerra.R

class ShareActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var mailTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        nameTextView = findViewById(R.id.name_show)
        mailTextView = findViewById(R.id.mail_show)
        phoneTextView = findViewById(R.id.phone_show)
        shareButton = findViewById(R.id.shareAction)

        val nameShare = intent.getStringExtra("name").toString()
        val mailShare = intent.getStringExtra("mail").toString()
        val phoneShare = intent.getStringExtra("phone").toString()

        nameTextView.text = "${nameShare}"
        mailTextView.text = "${mailShare}"
        phoneTextView.text = "${phoneShare}"

        shareButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nombre: ${nameShare}, Correo: ${mailShare}, Telefono: ${phoneShare}")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }


    }
}