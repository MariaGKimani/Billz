package mariadev.example.billz

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mariadev.example.billz.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnlogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = binding.etname.text.toString()
        val password = binding.etpassword.text.toString()

        if (validateInputs(username, password)) {

           Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInputs(username: String, password: String): Boolean {
        if (username.isEmpty()) {
            binding.etname.error = "Username cannot be empty"
            return false
        }

        if (password.isEmpty()) {
            binding.etpassword.error = "Password cannot be empty"
            return false
        }

        return true
    }
}