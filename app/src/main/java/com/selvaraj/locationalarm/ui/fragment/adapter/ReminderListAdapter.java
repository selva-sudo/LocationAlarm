package com.selvaraj.locationalarm.ui.fragment.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.selvaraj.locationalarm.R;
import com.selvaraj.locationalarm.Revisitor;
import com.selvaraj.locationalarm.entity.StoredReminder;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Selvaraj on 21/02/17.</p>
 */
public class ReminderListAdapter extends RecyclerView.Adapter<ReminderListAdapter.ReminderViewHolder> {

    final private Context mContext;
    final private LayoutInflater mInflater;
    private List<StoredReminder> mData;
    private Resources mRes;

    public ReminderListAdapter(Context context) {
        this.mContext = context.getApplicationContext();
        mInflater = LayoutInflater.from(context);
        this.mData = new ArrayList<>();
        this.mRes = context.getResources();
    }

    /**
     * Sets the data to the adapter
     *
     * @param data
     */
    public void setData(ArrayList<StoredReminder> data) {
        this.mData.clear();
        if (data != null) {
            this.mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    public StoredReminder getReminder(int position) {
        return this.mData.get(position);
    }

    public interface OnCardClickListener {

        /**
         * Called whenever a card is pressed
         *
         * @param view The view that was clicked
         * @param pos  The position of the card
         */
        void onCardClicked(View view, int pos);

        /**
         * Called whenver the options of a card has been pressed
         *
         * @param view     The view that was clicked
         * @param position The position of the card
         */
        void onCardOptionsClicked(View view, int position);
    }

    private OnCardClickListener mListener;

    public void setOnCardClickListener(OnCardClickListener l) {
        this.mListener = l;

    }

    public class ReminderViewHolder extends RecyclerView.ViewHolder {

        public TextView mNote;
        public TextView mPlace;
        public TextView mDistance;
        public CardView mCard;

        public ImageButton mCardOptions;

        public ReminderViewHolder(final View view) {
            super(view);
            this.mNote = (TextView) view.findViewById(R.id.note);
            this.mPlace = (TextView) view.findViewById(R.id.place);
            this.mDistance = (TextView) view.findViewById(R.id.distance);
            this.mCardOptions = (ImageButton) view.findViewById(R.id.card_options);
            this.mCard = (CardView) view.findViewById(R.id.card_view);

            this.mCardOptions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ReminderListAdapter.this.mListener.onCardOptionsClicked(mCardOptions, getPosition());
                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ReminderListAdapter.this.mListener.onCardClicked(mCard, getPosition());
                }
            });
        }

    }


    @Override
    public ReminderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_card_reminder, parent, false);
        final ReminderViewHolder vh = new ReminderViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(ReminderViewHolder holder, int position) {
        StoredReminder mLocationPlace = mData.get(position);
        holder.mNote.setText(mLocationPlace.getNote());

        holder.mPlace.setText(mLocationPlace.getPrettyLocation(mContext));
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}
