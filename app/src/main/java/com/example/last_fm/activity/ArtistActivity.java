package com.example.last_fm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.last_fm.R;
import com.example.last_fm.adapter.RecyclerItemClickListener;
import com.example.last_fm.adapter.RecyclerViewAdapterForArtist;
import com.example.last_fm.model.by_artist.AlbumByArtist;
import com.example.last_fm.model.by_artist.DataByArtist;
import com.example.last_fm.model.by_artist.TopAlbumsByArtist;
import com.example.last_fm.retrofit.ApiService;
import com.example.last_fm.retrofit.RestManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_for_artist)
    protected Toolbar toolbar_for_artist;
    @BindView(R.id.recycler_view_for_album)
    protected RecyclerView recycler_view_for_album;

    private ApiService apiService;

    private String name_of_artist;

    private List<AlbumByArtist> for_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        ButterKnife.bind(this);

        initHelpingClasses();
        getNameByIntent();
        initToolbar();
        initRecyclerView();
    }

    private void initHelpingClasses() {
        apiService = RestManager.getRetrofit(getApplicationContext());
    }

    private void getNameByIntent() {
        Intent intent = getIntent();
        name_of_artist = intent.getStringExtra("name");
    }

    private void initToolbar() {
        setSupportActionBar(toolbar_for_artist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle(name_of_artist);
    }

    private void initRecyclerView() {
        apiService.getDataByArtist(name_of_artist).enqueue(new Callback<DataByArtist>() {
            @Override
            public void onResponse(Call<DataByArtist> call, Response<DataByArtist> response) {
                DataByArtist dataByArtist = response.body();
                TopAlbumsByArtist topAlbumsByArtist = dataByArtist.getTopAlbumsByArtist();
                List<AlbumByArtist> albumByArtist = topAlbumsByArtist.getAlbumByArtist();

                for_click = albumByArtist;

                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

                recycler_view_for_album.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recycler_view_for_album.setAdapter(new RecyclerViewAdapterForArtist(albumByArtist,
                        R.layout.element_list_artist, getApplicationContext()));

                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler_view_for_album.getContext(),
                        layoutManager.getOrientation());
                recycler_view_for_album.addItemDecoration(dividerItemDecoration);
            }

            @Override
            public void onFailure(Call<DataByArtist> call, Throwable t) {

            }
        });

        recycler_view_for_album.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                recycler_view_for_album, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(ArtistActivity.this, AlbumActivity.class);
                intent.putExtra("artist_name", name_of_artist);
                intent.putExtra("album_name", for_click.get(position).getName());
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
