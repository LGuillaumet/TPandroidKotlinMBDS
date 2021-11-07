package android.mbds.tp1.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class ComputeActiviy : AppCompatActivity(){
    private lateinit var computeButton: Button
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (editText1.text.isNotEmpty() || editText2.text.isNotEmpty()) {
                computeButton.isEnabled = true
            }
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)

        computeButton = findViewById(R.id.btn_calculer)
        editText1 = findViewById(R.id.field_1)
        editText2 = findViewById(R.id.field_2)
        computeButton.isEnabled = false
        editText1.addTextChangedListener(textWatcher)
        editText2.addTextChangedListener(textWatcher)

        computeButton.setOnClickListener {

        }





    }

}