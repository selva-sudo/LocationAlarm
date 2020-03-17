package com.selvaraj.locationalarm.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.selvaraj.locationalarm.R;


/**
 * <p>Created by Selvaraj on 15/02/17.</p>
 */
public class AboutDialog extends BaseDialog {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        StringBuilder str = new StringBuilder();
        str.append(getString(R.string.about_message_by))
                .append("\n\n")
                .append(getString(R.string.about_message_contact));

        Dialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.app_name)
                .setMessage(str.toString())
                .setNegativeButton(R.string.close, null)
                .create();
        return dialog;
    }
}
