package com.selvaraj.locationalarm.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.selvaraj.locationalarm.ui.BaseDialog;

/**
 * <p>Created by Selvaraj on 28/02/17.</p>
 */
public class ProgressDialog extends BaseDialog {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new android.app.ProgressDialog(getActivity());
    }
}
