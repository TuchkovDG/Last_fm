package com.example.last_fm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.last_fm.R;
import com.example.last_fm.custom.SquareImageView;
import com.example.last_fm.model.by_artist.AlbumByArtist;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterForArtist extends RecyclerView.Adapter<RecyclerViewAdapterForArtist.ViewHolder> {

    private List<AlbumByArtist> albumsByArtist;
    private int rowLayout;
    private Context context;

    static class ViewHolder extends RecyclerView.ViewHolder {
        SquareImageView album_image;
        TextView title;
        TextView play_count;

        ViewHolder(View view) {
            super(view);
            album_image = (SquareImageView) view.findViewById(R.id.image_album);
            title = (TextView) view.findViewById(R.id.textView_album_name);
            play_count = (TextView) view.findViewById(R.id.textView_play_count);
        }
    }

    public RecyclerViewAdapterForArtist(List<AlbumByArtist> albumsByArtist, int rowLayout, Context context) {
        this.albumsByArtist = albumsByArtist;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapterForArtist.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new RecyclerViewAdapterForArtist.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterForArtist.ViewHolder viewHolder, final int position) {
        if (albumsByArtist.get(position).getImage().get(3)
                .getText().isEmpty()) {
            viewHolder.album_image.setImageResource(R.mipmap.ic_launcher);
        } else {
            Picasso.with(context).load(albumsByArtist.get(position).getImage().get(3)
                    .getText()).into(viewHolder.album_image);
        }
        viewHolder.title.setText(albumsByArtist.get(position).getName());
        viewHolder.play_count.setText(albumsByArtist.get(position).getPlaycount() + " play count");
    }

    @Override
    public int getItemCount() {
        return albumsByArtist.size();
    }
}
