package `in`.abhisheksaxena.toaster

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout


/**
 * @author Abhishek Saxena
 * @since 17-08-2020 06:25
 */

object Toaster {

        const val LENGTH_SHORT = Toast.LENGTH_SHORT
        const val LENGTH_LONG = Toast.LENGTH_LONG

        fun pop(
            context: Context,
            message: CharSequence,
            drawableRes: Int? = null,
            duration: Int = LENGTH_SHORT
        ): Toast {

            val toast = Toast(context)

            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.layout_toast, ConstraintLayout(context), false)

            val messageTextView = view.findViewById<TextView>(R.id.message_text_view)
            messageTextView.text = message

            val leftDrawable = view.findViewById<ImageView>(R.id.left_drawable_image_view)
            drawableRes?.let {
                leftDrawable.setImageResource(it)
            }

            toast.duration = duration
            toast.view = view
            return toast
        }
}