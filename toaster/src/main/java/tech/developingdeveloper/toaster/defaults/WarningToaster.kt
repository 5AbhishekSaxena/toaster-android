package tech.developingdeveloper.toaster.defaults

import android.content.Context
import tech.developingdeveloper.toaster.R
import tech.developingdeveloper.toaster.Toaster
import tech.developingdeveloper.toaster.utils.Colors

internal object WarningToaster : DefaultToaster {
    override fun create(context: Context, message: CharSequence, duration: Int): Toaster {
        return Toaster.Builder(context)
            .setMessage(message)
            .setLeftDrawable(R.drawable.ic_baseline_warning_24)
            .setLeftDrawableTint(Colors.WARNING)
            .setStripTint(Colors.WARNING)
            .setDuration(duration)
            .make()
    }
}
