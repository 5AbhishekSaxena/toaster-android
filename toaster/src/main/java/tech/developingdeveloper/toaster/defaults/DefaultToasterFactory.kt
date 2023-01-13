package tech.developingdeveloper.toaster.defaults

import android.content.Context
import tech.developingdeveloper.toaster.DefaultToasterType
import tech.developingdeveloper.toaster.Toaster

/**
 * A simple factory to return [DefaultToaster] instance from [DefaultToasterType]. It uses
 * [java.util.EnumMap] to map the [DefaultToasterType] with the [DefaultToaster]. The map is provided
 * using [ToasterMapProvider] which handles the mapping of the enum to the implementation.
 */
internal object DefaultToasterFactory {

    private val toasterMap = ToasterMapProvider.provide()

    fun create(
        context: Context,
        message: CharSequence,
        duration: Int,
        toasterType: DefaultToasterType,
    ): Toaster {
        val defaultToaster = toasterMap[toasterType]
            ?: throw IllegalArgumentException("Unknown toaster type.")
        return defaultToaster.create(context, message, duration)
    }
}