package tech.developingdeveloper.toasterexample

import tech.developingdeveloper.toaster.Toaster
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            Toaster.pop(
                this,
                "A simple toast message",
                Toaster.LENGTH_SHORT
            ).show()
        }

        with_image_button.setOnClickListener {
            Toaster.pop(
                this,
                "A simple toast message with image",
                R.drawable.ic_baseline_cloud_done_24,
                Toaster.LENGTH_SHORT
            ).show()
        }

        builder_button.setOnClickListener {
            val toastBuilder = Toaster.Builder(this)
                .setMessage("File uploaded successfully")
                .setLeftDrawable(R.drawable.ic_baseline_cloud_done_24)
                .setLeftDrawableTint(R.color.blue)
                .setStripTint(R.color.blue)
                .setDuration(Toaster.LENGTH_SHORT)
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

        success_button.setOnClickListener {
            Toaster.popSuccess(
                this,
                "This is a success message",
                Toaster.LENGTH_SHORT
            ).show()
        }
    }
}