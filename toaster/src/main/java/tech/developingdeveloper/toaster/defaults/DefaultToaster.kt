package tech.developingdeveloper.toaster.defaults

import android.content.Context
import tech.developingdeveloper.toaster.Toaster

/**
 * This interface provides a [create] method that will be used to generate a
 * default [Toaster] for different scenarios.
 */
internal interface DefaultToaster {
    fun create(
        context: Context,
        message: CharSequence,
        duration: Int,
    ): Toaster
}
