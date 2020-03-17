package com.selvaraj.locationalarm.ui;

import android.app.Activity;

import androidx.fragment.app.Fragment;

/**
 * <p>Created by Selvaraj on 17/02/17.</p>
 */
public class BaseFragment extends Fragment {


    private BaseActivity mActivity;

    @Override
    public void onAttach(Activity activity) {

        try {
            mActivity = (BaseActivity) activity;
        } catch (ClassCastException ex) {
            throw new RuntimeException(this.getClass().getSimpleName() + " can only be attached to a BaseActivity");
        }
        super.onAttach(activity);
    }

    /**
     * Returns the parent {@linkplain BaseActivity} of this fragment.
     *
     */
    protected BaseActivity getBaseActivity() {
        return mActivity;
    }
}
