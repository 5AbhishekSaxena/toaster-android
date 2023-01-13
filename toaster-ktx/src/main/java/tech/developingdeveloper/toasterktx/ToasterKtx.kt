package tech.developingdeveloper.toasterktx

import android.content.Context
import android.widget.Toast
import tech.developingdeveloper.toaster.Toaster

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