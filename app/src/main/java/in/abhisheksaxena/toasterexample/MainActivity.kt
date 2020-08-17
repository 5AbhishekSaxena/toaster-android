package `in`.abhisheksaxena.toasterexample

import `in`.abhisheksaxena.toaster.Toaster
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message = "Some message"
        button.setOnClickListener {
            Toaster.pop(
                this,
                message,
                Toaster.LENGTH_SHORT
            ).show()
        }

        builder_button.setOnClickListener {
            val toastBuilder = Toaster.Builder(this)
                .setMessage("Some default message")
            Toaster.pop(toastBuilder.make()).show()
        }

        error_button.setOnClickListener {
            Toaster.popError(
                this,
                "This is an error message",
                Toaster.LENGTH_SHORT
            ).show()
        }

        warning_button.setOnClickListener {
            Toaster.popWarning(
                this,
                "This is a warning message",
                Toaster.LENGTH_SHORT
            ).show()
        }
    }
}