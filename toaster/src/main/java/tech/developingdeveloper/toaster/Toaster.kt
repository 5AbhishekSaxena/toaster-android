package tech.developingdeveloper.toaster

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import tech.developingdeveloper.toaster.defaults.ErrorToaster
import tech.developingdeveloper.toaster.defaults.SuccessToaster
import tech.developingdeveloper.toaster.defaults.WarningToaster
import tech.developingdeveloper.toaster.utils.visibleIf


/**
 * @author Abhishek Saxena
 * @since 17-08-2020 06:25
 */

class Toaster private constructor(
    private val context: Context,
    private var message: CharSequence,
    private var duration: Int
) {

    private var rootView: View? = null
    private var leftDrawableRes: Int? = null

    companion object {
        const val LENGTH_SHORT = Toast.LENGTH_SHORT
        const val LENGTH_LONG = Toast.LENGTH_LONG

        /**
         * Used to create a [Toast] that has some default values based on the supplied [toasterType].
         */
        fun popDefault(
            context: Context,
            message: CharSequence,
            duration: Int,
            toasterType: DefaultToasterType,
        ): Toast {
            val defaultToaster = when (toasterType) {
                DefaultToasterType.SUCCESS -> SuccessToaster.create(context, message, duration)
                DefaultToasterType.WARNING -> WarningToaster.create(context, message, duration)
                DefaultToasterType.ERROR -> ErrorToaster.create(context, message, duration)
            }

            return pop(defaultToaster)
        }

        fun pop(
            context: Context,
            message: CharSequence,
            duration: Int,
            drawableRes: Int? = null,
        ): Toast {
            return pop(prepare(context, message, duration, drawableRes))
        }

        fun pop(toaster: Toaster): Toast {
            return if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
                Toast(toaster.context).apply {
                    duration = toaster.duration
                    view = toaster.rootView
                }
            } else {
                Toast.makeText(toaster.context, toaster.message, toaster.duration)
            }
        }

        private fun prepare(
            context: Context,
            message: CharSequence,
            duration: Int,
            drawableRes: Int? = null,
        ): Toaster {
            return Config(
                message = message,
                leftDrawableRes = drawableRes,
                duration = duration,
            ).make(context)
        }
    }

    /**
     * In Kotlin, since we can have default parameters, we have less of a need for a builder pattern.
     *
     * We can create a single data class that has a property for every customizable field, and then
     * in [make] we can read our properties and configure our view based on that.
     */
    data class Config(
        private var message: CharSequence = "",
        private var duration: Int = LENGTH_SHORT,
        @DrawableRes
        private var leftDrawableRes: Int? = null,
        @ColorRes
        private var leftDrawableTint: Int? = null,
        @ColorRes
        private var stripTint: Int? = null,
    ) {
        fun make(context: Context): Toaster {
            return Toaster(context, message, duration).also {
                it.rootView = buildView(context)
                it.leftDrawableRes = leftDrawableRes
            }
        }

        /**
         * Creates a [View] for a [Toaster] that matches this [Config].
         */
        private fun buildView(context: Context): View {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rootView = inflater.inflate(R.layout.layout_toast, ConstraintLayout(context), false)

            val messageTextView: TextView = rootView.findViewById(R.id.message_text_view)
            val leftDrawableImageView: ImageView = rootView.findViewById(R.id.left_drawable_image_view)
            val colorStripView: View = rootView.findViewById(R.id.color_strip_view)

            messageTextView.text = this.message
            messageTextView.visibleIf(this.message.isNotEmpty())

            leftDrawableRes?.let(leftDrawableImageView::setImageResource)
            leftDrawableImageView.visibleIf(leftDrawableRes != null)

            val tintColor = this.leftDrawableTint?.let { tintRes ->
                ContextCompat.getColor(context, tintRes)
            }
            tintColor?.let(leftDrawableImageView::setColorFilter)

            val stripColor = this.stripTint?.let { tintRes ->
                ContextCompat.getColor(context, tintRes)
            }
            stripColor?.let(colorStripView::setBackgroundColor)
            colorStripView.visibleIf(stripColor != null)

            return rootView
        }
    }
}