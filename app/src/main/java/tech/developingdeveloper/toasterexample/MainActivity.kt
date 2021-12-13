package tech.developingdeveloper.toasterexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.developingdeveloper.toaster.DefaultToasterType
import tech.developingdeveloper.toaster.Toaster
import tech.developingdeveloper.toasterexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            Toaster.pop(
                this,
                "A simple toast message",
                Toaster.LENGTH_SHORT
            ).show()
        }

        binding.withImageButton.setOnClickListener {
            Toaster.pop(
                this,
                "A simple toast message with image",
                R.drawable.ic_baseline_cloud_done_24,
                Toaster.LENGTH_SHORT
            ).show()
        }

        binding.builderButton.setOnClickListener {
            val toastBuilder = Toaster.Builder(this)
                .setMessage("File uploaded successfully")
                .setLeftDrawable(R.drawable.ic_baseline_cloud_done_24)
                .setLeftDrawableTint(R.color.blue)
                .setStripTint(R.color.blue)
                .setDuration(Toaster.LENGTH_SHORT)
            Toaster.pop(toastBuilder.make()).show()
        }

        binding.errorButton.setOnClickListener {
            Toaster.popDefault(
                context = this,
                message = "This is an error message",
                duration = Toaster.LENGTH_SHORT,
                toasterType = DefaultToasterType.ERROR,
            ).show()
        }

        binding.warningButton.setOnClickListener {
            Toaster.popDefault(
                context = this,
                message = "This is a warning message",
                duration = Toaster.LENGTH_SHORT,
                toasterType = DefaultToasterType.WARNING,
            ).show()
        }

        binding.successButton.setOnClickListener {
            Toaster.popDefault(
                context = this,
                message = "This is a success message",
                duration = Toaster.LENGTH_SHORT,
                toasterType = DefaultToasterType.SUCCESS,
            ).show()
        }
    }
}