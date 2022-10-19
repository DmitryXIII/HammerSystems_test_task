package com.avacodo.hammersystemstesttask.presentation.extensions

import android.app.Activity
import android.content.DialogInterface
import androidx.annotation.StringRes
import com.avacodo.hammersystemstesttask.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Activity.showAlertDialogWithoutNegativeButton(
    @StringRes title: Int,
    @StringRes message: Int,
    @StringRes positiveButton: Int = R.string.default_alert_positive_button,
    onPositiveAction: (dialog: DialogInterface) -> Unit,
) {
    MaterialAlertDialogBuilder(this)
        .setTitle(getString(title))
        .setMessage(getString(message))
        .setPositiveButton(getString(positiveButton)) { dialog, _ ->
            onPositiveAction.invoke(dialog)
        }
        .show()
}



