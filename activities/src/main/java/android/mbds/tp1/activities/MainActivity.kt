package android.mbds.tp1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {


    private lateinit var clickButton: Button
    private lateinit var computeButton: Button
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickButton = findViewById(R.id.btn_click_me)
        computeButton = findViewById(R.id.btn_compute)

        textView = findViewById(R.id.textViewCompteur)

        clickButton.setOnClickListener {
            Toast.makeText(baseContext, "Tu m'as cliqué", Toast.LENGTH_LONG).show()
        }

        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActiviy::class.java)
            startActivity(intent)
        }
        textView.isVisible=false

        clickButton.setOnClickListener {
            if (nbClick > 0) {
                textView.isVisible = true
            }
            nbClick++
            if (nbClick == 5) {
                clickButton.isEnabled = false
            }
            val newText = "vous avez cliquer $nbClick fois"
            textView.text = newText

        }

    }


    private var nbClick = 0


}