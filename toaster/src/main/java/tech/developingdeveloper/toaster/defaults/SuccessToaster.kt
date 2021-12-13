package tech.developingdeveloper.toaster.defaults

import android.content.Context
import tech.developingdeveloper.toaster.R
import tech.developingdeveloper.toaster.Toaster
import tech.developingdeveloper.toaster.utils.Colors

internal object SuccessToaster : DefaultToaster {
    override fun create(
        context: Context,
        message: CharSequence,
        duration: Int,
    ): Toaster {
        return Toaster.Builder(context)
            .setMessage(message)
            .setLeftDrawable(R.drawable.ic_baseline_check_circle_24)
            .setLeftDrawableTint(Colors.SUCCESS)
            .setStripTint(Colors.SUCCESS)
            .setDuration(duration)
            .make()
    }
}
