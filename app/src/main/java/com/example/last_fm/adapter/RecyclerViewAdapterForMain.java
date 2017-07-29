package com.example.last_fm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.last_fm.R;
import com.example.last_fm.model.by_country.ArtistByCountry;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterForMain extends RecyclerView.Adapter<RecyclerViewAdapterForMain.ViewHolder> {

    private List<ArtistByCountry> artistByCountries;
    private int rowLayout;
    private Context context;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView group;
        TextView title;
        TextView listener;

        ViewHolder(View view) {
            super(view);
            group = (ImageView) view.findViewById(R.id.image_group);
            title = (TextView) view.findViewById(R.id.textView_name);
            listener = (TextView) view.findViewById(R.id.textView_listener);
        }
    }

    public RecyclerViewAdapterForMain(List<ArtistByCountry> artistByCountries, int rowLayout, Context context) {
        this.artistByCountries = artistByCountries;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapterForMain.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new RecyclerViewAdapterForMain.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterForMain.ViewHolder viewHolder, final int position) {
        Picasso.with(context).load(artistByCountries.get(position).getImage().get(2)
                .getText()).into(viewHolder.group);
        viewHolder.title.setText(artistByCountries.get(position).getName());
        viewHolder.listener.setText("(" + artistByCountries.get(position).getListeners() + " listeners)");
    }

    @Override
    public int getItemCount() {
        return artistByCountries.size();
    }
}
