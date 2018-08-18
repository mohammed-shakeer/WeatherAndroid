package com.weather.mohammedshakeer.weather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weather.mohammedshakeer.weather.R;
import com.weather.mohammedshakeer.weather.fragments.WeatherListFragment;
import com.weather.mohammedshakeer.weather.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MohammedShakeer on 18/08/18.
 */

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.ViewHolder> {

    private List<Item> mItems;
    PostItemListener mItemListener;

    public WeatherListAdapter(Context weatherListFragment, List<Item> items, PostItemListener postItemListener) {

        mItemListener = postItemListener;
        mItems = items;
    }

    public void updateWeather(List<Item> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final PostItemListener mItemListener;
        public TextView textViewDate;
        public TextView textViewDesc;
        public TextView textViewTemp;
        public TextView textViewTempRange;
        public TextView textViewHumidity;

        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            textViewTemp = itemView.findViewById(R.id.textViewTemp);
            textViewTempRange = itemView.findViewById(R.id.textViewTempRange);
            textViewHumidity = itemView.findViewById(R.id.textViewHumidity);
        }

        @Override
        public void onClick(View view) {

            Item item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item);
            notifyDataSetChanged();
        }
    }

    @Override
    public WeatherListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View postView = inflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherListAdapter.ViewHolder holder, int position) {

        Item item = mItems.get(position);
        holder.textViewDate.setText(item.getDate());
        holder.textViewDesc.setText(item.getDescription().get(0).getDescription());
        holder.textViewTemp.setText(item.getMain().getTemp());
        holder.textViewTempRange.setText(item.getMain().getTemp_range());
        holder.textViewHumidity.setText(item.getMain().getHumidity());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public Item getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(Item id);
    }
}
