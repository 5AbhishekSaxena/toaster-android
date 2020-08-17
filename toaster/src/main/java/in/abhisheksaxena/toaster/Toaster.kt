package `in`.abhisheksaxena.toaster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout


/**
 * @author Abhishek Saxena
 * @since 17-08-2020 06:25
 */

class Toaster private constructor(
    private val context: Context,
    private var message: CharSequence,
    private var drawableRes: Int?
) {


    companion object {
        private var messageTextView: TextView? = null
        private var leftDrawable: ImageView? = null
        private lateinit var toast: Toast
        const val LENGTH_SHORT = Toast.LENGTH_SHORT
        const val LENGTH_LONG = Toast.LENGTH_LONG

        fun pop(
            context: Context,
            message: CharSequence,
            drawableRes: Int? = null,
            duration: Int = LENGTH_SHORT
        ): Toast {
            val rootView = initView(context)
            prepare(message, drawableRes)
            toast.duration = duration
            toast.view = rootView
            return toast
        }

        fun pop(toaster: Toaster): Toast {
            val rootView = initView(toaster.context)
            prepare(toaster.message, toaster.drawableRes)
            toast.view = rootView
            return toast
        }

        private fun initView(context: Context): View {
            toast = Toast(context)

            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rootView = inflater.inflate(R.layout.layout_toast, ConstraintLayout(context), false)

            messageTextView = rootView.findViewById(R.id.message_text_view)
            leftDrawable = rootView.findViewById(R.id.left_drawable_image_view)

            return rootView
        }

        private fun prepare(message: CharSequence, drawableRes: Int?) {
            messageTextView?.text = message
            drawableRes?.let {
                leftDrawable?.setImageResource(it)
            }
        }
    }

    class Builder(private val context: Context) {

        private var message: CharSequence = ""
        private var leftDrawableRes: Int? = null

        fun setMessage(message: CharSequence) = apply {
            this.message = message
        }

        fun setLeftDrawable(leftDrawableRes: Int) = apply {
            this.leftDrawableRes = leftDrawableRes
        }

        fun make(): Toaster {
            return Toaster(context, message, leftDrawableRes)
        }
    }
}