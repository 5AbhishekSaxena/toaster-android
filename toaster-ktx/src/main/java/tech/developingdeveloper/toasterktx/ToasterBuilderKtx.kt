package tech.developingdeveloper.toasterktx

import android.content.Context
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import tech.developingdeveloper.toaster.Toaster


/**
 * @author Abhishek Saxena
 * @since 07-09-2021 12:01
 */

class ToasterBuilderKtx private constructor(private val context: Context) {

    @DrawableRes
    var leftDrawableRes: Int = DEFAULT_VALUE

    @ColorRes
    var leftDrawableTint: Int = DEFAULT_VALUE

    @ColorRes
    var stripTint: Int = DEFAULT_VALUE

    var message: CharSequence = ""
    var duration: Int = Toaster.LENGTH_SHORT

    private fun prepare(): Toaster {
        val toasterBuilder = Toaster.Builder(context)
            .setMessage(message)
            .setDuration(duration)

        if (leftDrawableRes != DEFAULT_VALUE)
            toasterBuilder.setLeftDrawable(leftDrawableRes)

        if (leftDrawableTint != DEFAULT_VALUE)
            toasterBuilder.setLeftDrawableTint(leftDrawableTint)

        if (stripTint != DEFAULT_VALUE)
            toasterBuilder.setStripTint(stripTint)

        return toasterBuilder.make()
    }

    companion object {
        private const val DEFAULT_VALUE = -1

        fun prepareToast(
            context: Context,
            block: ToasterBuilderKtx.() -> Unit
        ): Toast {
            val toaster = prepareToaster(context, block)
            return Toaster.pop(toaster)
        }

        fun prepareToaster(
            context: Context,
            block: ToasterBuilderKtx.() -> Unit
        ): Toaster {
            val toastBuilder = ToasterBuilderKtx(context).apply(block)
            return toastBuilder.prepare()
        }
    }
}
