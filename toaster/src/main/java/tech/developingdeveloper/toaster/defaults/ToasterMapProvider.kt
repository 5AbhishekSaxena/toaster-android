package tech.developingdeveloper.toaster.defaults

import tech.developingdeveloper.toaster.DefaultToasterType
import java.util.EnumMap

/**
 * It is responsible for mapping [DefaultToasterType] to [DefaultToaster].
 */
internal object ToasterMapProvider {
    fun provide(): EnumMap<DefaultToasterType, DefaultToaster> = EnumMap(
        mapOf(
            DefaultToasterType.SUCCESS to SuccessToaster,
            DefaultToasterType.WARNING to WarningToaster,
            DefaultToasterType.ERROR to ErrorToaster,
        )
    )
}