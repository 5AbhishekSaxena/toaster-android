package tech.developingdeveloper.toaster.utils

import android.view.View

internal fun View.visibleIf(condition: Boolean?) {
    this.visibility = if (condition == true) View.VISIBLE else View.GONE
}