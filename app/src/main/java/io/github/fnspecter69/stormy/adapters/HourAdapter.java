package io.github.fnspecter69.stormy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.fnspecter69.stormy.R;
import io.github.fnspecter69.stormy.weather.Hour;

/**
 * Project:     Stormy
 * FileName:    HourAdapter.java
 * Author:      Fred Niederhauser
 * Date:        8/25/2015
 * Description: find a way to use recyclerView itemList animator to make it more fun
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder>{
    private Hour[] mHours;
    private Context mContext;

    public HourAdapter(Context context, Hour[] hours){
        mContext = context;
        mHours = hours;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hourly_list_item, parent, false);
        HourViewHolder viewHolder = new HourViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        holder.bindHour(mHours[position]);
    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }

    public class HourViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        @Bind(R.id.timeLabel) TextView mTimeLabel;
        @Bind(R.id.summaryLabel) TextView mSummaryLabel;
        @Bind(R.id.temperatureLabel)TextView mTempLabel;
        @Bind(R.id.iconImageView)ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        public void bindHour(Hour hour){
            mTimeLabel.setText(hour.getHour());
            mSummaryLabel.setText(hour.getSummary());
            mTempLabel.setText(hour.getTemperature() + "");
            mIconImageView.setImageResource(hour.getIconId());
        }

        @Override
        public void onClick(View view) {
            String time = mTimeLabel.getText().toString();
            String temperature = mTempLabel.getText().toString();
            String summary = mSummaryLabel.getText().toString();
            String msg = String.format("At %s it will be %s and %s",
                    time,
                    temperature,
                    summary);
            Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
        }
    }


}
