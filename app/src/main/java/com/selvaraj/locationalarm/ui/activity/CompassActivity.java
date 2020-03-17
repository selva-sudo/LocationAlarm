package com.selvaraj.locationalarm.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.selvaraj.locationalarm.App;
import com.selvaraj.locationalarm.DeLog;
import com.selvaraj.locationalarm.R;
import com.selvaraj.locationalarm.ui.BaseActivity;
import com.selvaraj.locationalarm.ui.fragment.CompassFragment;

/**
 * <p>Created by Selvaraj on 22/02/17.</p>
 */
public class CompassActivity extends BaseActivity {


    public static final String EXTRA_REMINDER_ID = App.PACKAGE + ".REMINDER_ID";
    private static final String TAG = "CompassActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);

        Bundle extras = getIntent().getExtras();
        if (!extras.containsKey(EXTRA_REMINDER_ID)) {
            DeLog.w(TAG, "Cannot show activity without reminder ID");
            finish();
            return;
        }

        if (savedInstanceState == null) {
            CompassFragment frag = CompassFragment.newInstance(extras.getLong(EXTRA_REMINDER_ID));
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.compass_holder, frag).commit();

        }

    }

    /**
     * Starts the CompassActivity that will point to a reminder of the given id!
     *
     * @param context    The context to use
     * @param reminderID The id of the reminder to point at
     */
    public static void startActivity(Context context, long reminderID) {
        Intent i = new Intent(context, CompassActivity.class);
        i.putExtra(EXTRA_REMINDER_ID, reminderID);
        context.startActivity(i);

    }
}
