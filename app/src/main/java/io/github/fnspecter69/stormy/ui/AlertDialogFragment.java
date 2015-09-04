package io.github.fnspecter69.stormy.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import io.github.fnspecter69.stormy.R;

/**
 * Project      Stormy
 * Author:      Fred Niederhauser
 * Date:        6/24/2015
 * Description:
 */
public class AlertDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.error_tittle))
                .setMessage(context.getString(R.string.error_message))
                .setPositiveButton(context.getString(R.string.ok_button), null);

        AlertDialog dialog = builder.create();
        return  dialog;
    }
}
