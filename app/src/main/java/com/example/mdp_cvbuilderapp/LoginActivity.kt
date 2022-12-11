package com.example.mdp_cvbuilderapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mdp_cvbuilderapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*In order to use shared preferences, I have to call a method getPreferences()
         that returns a SharedPreference instance pointing to the file that contains
         the values of preferences.
       */
        sharedPref = SharedPreferenceUtils.setPref(this)

        val user = SharedPreferenceUtils.getPref(getString(R.string.username))
        val pass = SharedPreferenceUtils.getPref(getString(R.string.password))
        user?.let { binding.email.setText(it) }
        pass?.let { binding.pass.setText(it) }


    }

    fun onLogin(view: View) {
        val user = binding.email.text.toString().trim()
        val pass = binding.pass.text.toString().trim()

        if(user.isEmpty()){
            Toast.makeText(applicationContext,"Please provide  username", Toast.LENGTH_LONG).show()
            return
        }
        if(pass.isEmpty()){
            Toast.makeText(applicationContext,"Please provide password", Toast.LENGTH_LONG).show()
            return
        }

        with(sharedPref.edit()) {
            putString(getString(R.string.username), user)
            putString(getString(R.string.password), pass)
            apply()
        }

        startActivity(Intent(this, MainActivity::class.java))
    }


}