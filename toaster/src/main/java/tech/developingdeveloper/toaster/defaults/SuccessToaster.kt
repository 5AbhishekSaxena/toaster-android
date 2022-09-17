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
        return Toaster.Config(
            message = message,
            leftDrawableRes = R.drawable.ic_baseline_check_circle_24,
            leftDrawableTint = Colors.SUCCESS,
            stripTint = Colors.SUCCESS,
            duration = duration,
        ).make(context)
    }
}
