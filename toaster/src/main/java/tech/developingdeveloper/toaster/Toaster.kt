package tech.developingdeveloper.toaster

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import tech.developingdeveloper.toaster.defaults.ErrorToaster
import tech.developingdeveloper.toaster.defaults.SuccessToaster
import tech.developingdeveloper.toaster.defaults.WarningToaster


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
            val defaultToaster = when(toasterType) {
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
            return Builder(context)
                .setMessage(message)
                .apply {
                    drawableRes?.let {
                        setLeftDrawable(it)
                    }
                }
                .setDuration(duration)
                .make()
        }
    }

    class Builder(private val context: Context) {

        private val rootView: View
        private var messageTextView: TextView? = null
        private var leftDrawableImageView: ImageView? = null
        private var leftDrawableRes: Int? = null
        private var colorStripView: View? = null

        private var message: CharSequence = ""
        private var duration: Int = LENGTH_SHORT

        init {
            rootView = initView(context)
        }

        private fun initView(context: Context): View {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rootView = inflater.inflate(R.layout.layout_toast, ConstraintLayout(context), false)

            messageTextView = rootView.findViewById(R.id.message_text_view)
            leftDrawableImageView = rootView.findViewById(R.id.left_drawable_image_view)
            colorStripView = rootView.findViewById(R.id.color_strip_view)

            setInitViewProperties()

            return rootView
        }

        fun setMessage(message: CharSequence) = apply {
            this.message = message
            messageTextView?.text = message
            messageTextView?.visibility = View.VISIBLE
        }

        fun setLeftDrawable(leftDrawableRes: Int) = apply {
            this.leftDrawableRes = leftDrawableRes
            leftDrawableImageView?.setImageResource(leftDrawableRes)
            leftDrawableImageView?.visibility = View.VISIBLE
        }

        fun setDuration(duration: Int) = apply {
            this.duration = duration
        }

        fun setLeftDrawableTint(colorRes: Int) = apply {
            leftDrawableImageView?.setColorFilter(ContextCompat.getColor(context, colorRes))
            leftDrawableImageView?.visibility = View.VISIBLE
        }

        fun setStripTint(colorRes: Int) = apply {
            colorStripView?.setBackgroundColor(ContextCompat.getColor(this.context, colorRes))
            colorStripView?.visibility = View.VISIBLE
        }

        fun make(): Toaster {
            return Toaster(context, message, duration).also {
                it.rootView = rootView
                it.leftDrawableRes = leftDrawableRes
            }
        }

        private fun setInitViewProperties() {
            colorStripView?.visibility = View.GONE
            leftDrawableImageView?.visibility = View.GONE
            messageTextView?.visibility = View.GONE
        }
    }
}