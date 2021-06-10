package com.kanyideveloper.firebaseauthenticationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.kanyideveloper.firebaseauthenticationdemo.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.Registerbutton.setOnClickListener {
            //Views are blank, pass1 and pass2 are the same
            val email = binding.editTextaTextRegisterEmailAddress.text.toString()
            val password = binding.editTextTextRegisterPassword.text.toString()

            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "Account Created Successfuly", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}