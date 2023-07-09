package mariadev.example.billz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import mariadev.example.billz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsignup.setOnClickListener {
            signUp()
        }
        val loginButton: Button= findViewById(R.id.btnlogin2)
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signUp() {
        val username = binding.etusername.text.toString().trim()
        val phoneNumber = binding.etnumber.text.toString().trim()
        val email = binding.etemail.text.toString().trim()
        val password = binding.etaddress.text.toString().trim()

        if (validateInputs(username, phoneNumber, email, password)) {

            Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInputs(username: String, phoneNumber: String, email: String, password: String): Boolean {
        if (username.isEmpty()) {
            binding.etusername.error = "Username cannot be empty"
            return false
        }

        if (phoneNumber.isEmpty()) {
            binding.etnumber.error = "Phone number cannot be empty"
            return false
        }

        if (email.isEmpty()) {
            binding.tiladdress.error = "Email address cannot be empty"
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etemail.error = "Invalid email address"
            return false
        }


        return true
    }
}