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
            val toaster = Toaster.Config(
                message = "File uploaded successfully",
                leftDrawableRes = R.drawable.ic_baseline_cloud_done_24,
                leftDrawableTint = R.color.blue,
                stripTint = R.color.blue,
                duration = Toaster.LENGTH_SHORT,
            ).make(this)

            Toaster.pop(toaster).show()
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