package com.example.yannalakl_mb1_tp1

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.yannalakl_mb1_tp1.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val calendar = Calendar.getInstance()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clearButtonStatus()

        binding.birthdate.setOnClickListener {
            showDatePickerDialog()
        }
        binding.submit.setOnClickListener {
            submit()
        }
        binding.firstName.doAfterTextChanged { clearButtonStatus() }

        binding.clear.setOnClickListener {
            binding.firstName.setText("")
            binding.lastName.setText("")

            binding.birthdate.text = "BIRTHDATE"
            binding.nbCats.setText("")
            binding.nbDogs.setText("")
        }

    }
    private fun clearButtonStatus(){

        val enable = !binding.firstName.text.toString().isNotEmpty() ||
                     !binding.lastName.text.toString().isNotEmpty()||
                     !binding.birthdate.text.toString().isNotEmpty()||
                     !binding.nbCats.text.toString().isNotEmpty() ||
                     !binding.nbDogs.text.toString().isNotEmpty()

        binding.clear.isEnabled = enable



    }
    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                // This listener is called when a date is set
                updateDateLabel(year, monthOfYear, dayOfMonth)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    //tst

    private fun updateDateLabel(year: Int, month: Int, day: Int) {
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, day)

        val myFormat = "dd-MM-yyyy" // Your desired date format
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        binding.birthdate.text = sdf.format(calendar.time)
    }
    @SuppressLint("SuspiciousIndentation")
    private fun submit() {
        val firstName = binding.firstName.text.toString().trim()
        val lastName = binding.lastName.text.toString().trim()
        val birthdate = binding.birthdate.text.toString().trim()
        val nbCats = binding.nbCats.text.toString().trim()
        val nbDogs = binding.nbDogs.text.toString().trim()

        val message = "hello $firstName, $lastName, $birthdate, $nbCats, $nbDogs"

        binding.birthdate.text=message
        val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("message",message)
            startActivity(intent)
    }

}

