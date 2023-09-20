package com.example.email

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var emails: MutableList<Email>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val emailRV = findViewById<RecyclerView>(R.id.email)
        val newEmailBt = findViewById<Button>(R.id.addEmail)

        emails = EmailFetcher.getEmails()
        val adapter = EmailAdapter(emails)
        emailRV.adapter = adapter

        emailRV.layoutManager = LinearLayoutManager(this)

        newEmailBt.setOnClickListener(){
            val newEmails = EmailFetcher.getNext5Emails()
            emails.addAll(newEmails)
            adapter.notifyDataSetChanged()
        }


    }
}