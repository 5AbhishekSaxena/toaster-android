package `in`.abhisheksaxena.toasterexample

import `in`.abhisheksaxena.toaster.Toaster
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message = "Some message"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        button.setOnClickListener {
            Toaster.pop(
                this,
                message,
                R.drawable.ic_baseline_all_inclusive_24
            ).show()
        }
    }
}