package com.example.tedmate

import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Network policy stuff to allow the activity to make outbound network calls
        val policy = StrictMode.ThreadPolicy.Builder()
            .permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val button = findViewById<Button>(R.id.button_id)
        button.setOnClickListener{
            Toast.makeText(this, "You clicked", Toast.LENGTH_SHORT).show()
            URL("http://timer.tinyhop.com.au/timer").getText()
        }
    }

}

fun URL.getText(): String {
    return openConnection().run {
        this as HttpURLConnection
        inputStream.bufferedReader().readText()
    }
}