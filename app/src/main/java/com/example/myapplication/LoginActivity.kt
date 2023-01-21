 package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

 class LoginActivity : AppCompatActivity() {

     lateinit var sharedPreferences: SharedPreferences

    lateinit var etPhone: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView

    val validPhone = "8570849447"
     val validPassword = arrayOf("tony","captain","bruce","thanos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)

        if(isLoggedIn){
        val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            
        startActivity(intent)
        }else{
            setContentView(R.layout.activity_login)
        }
        setContentView(R.layout.activity_login)

        title = "Log IN"

        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)



        btnLogin.setOnClickListener {

            val phone = etPhone.text.toString()

            val password = etPassword.text.toString()

            var nameOfAvenger = "Avenger"

            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            if ((phone == validPhone) ){

             if(password == validPassword[0]){


                    nameOfAvenger = "Iron Man"
                 savePreference(nameOfAvenger)


                  startActivity(intent)

             } else if(password == validPassword[1]){

                 nameOfAvenger = "Steve Roger"

                 savePreference(nameOfAvenger)


                 startActivity(intent)

             }else if(password == validPassword[2]){


                 nameOfAvenger = "The Hulk"
                 savePreference(nameOfAvenger)

                 startActivity(intent)

             }else if(password == validPassword[3]){

                 nameOfAvenger = "The Avengers"
                 savePreference(nameOfAvenger)

                 startActivity(intent)

             }

         }

           else{
             Toast.makeText( this@LoginActivity, "Invalid credential", Toast.LENGTH_LONG).show()
         }
        }

    }

     override fun onPause() {
         super.onPause()
     finish()
     }

     fun savePreference(title:String){
         sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
         sharedPreferences.edit().putString("Title",title).apply()


     }
 }