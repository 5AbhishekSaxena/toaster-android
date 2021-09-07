package tech.developingdeveloper.toasterexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.developingdeveloper.toaster.Toaster
import tech.developingdeveloper.toasterexample.databinding.ActivityMainBinding
import tech.developingdeveloper.toasterktx.ToasterBuilderKtx


/**
 * @author Abhishek Saxena
 * @since 07-09-2021 13:10
 */

// This activity won't be visible in the app and it is only for reference.
// The output of this custom toast is same as custom toast using builder in MainActivity
class KtxExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.builderButton.setOnClickListener {
            val toaster = ToasterBuilderKtx.prepareToaster(this) {
                message = "File uploaded successfully"
                leftDrawableRes = R.drawable.ic_baseline_cloud_done_24
                leftDrawableTint = R.color.blue
                stripTint = R.color.blue
                duration = Toaster.LENGTH_SHORT
            }

            Toaster.pop(toaster).show()

            // or

            ToasterBuilderKtx.prepareToast(this) {
                message = "File uploaded successfully"
                leftDrawableRes = R.drawable.ic_baseline_cloud_done_24
                leftDrawableTint = R.color.blue
                stripTint = R.color.blue
                duration = Toaster.LENGTH_SHORT
            }.show()
        }
    }
}