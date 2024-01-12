package com.example.android_activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.android_activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //declaring the edit text and button which was created in .xml of main activity
    private lateinit var edit_main:EditText
    private lateinit var btn_main:Button
    private lateinit var returnText:TextView
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) // Checking if the result code indicates a successful operation.
            {
                val data: Intent? = result.data // Extracting data from the returned Intent
                val resultValue = data?.getIntExtra("RESULT", 0) // Extracting the result value from the Intent, defaulting to 0 if not present
                returnText.text = "Result after multiplying 2 : $resultValue"  // Updating the UI to display the result after multiplying 2
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //finding by Id to both the declared constrains.
        edit_main=findViewById(R.id.edit_main)
        btn_main=findViewById(R.id.btn_main)
        // this button sending the data from the main screen to the second activity screen
        btn_main.setOnClickListener { startActivity(Intent(this,SecondActivity::class.java).putExtra("number",edit_main.text.toString())) }
    }

}