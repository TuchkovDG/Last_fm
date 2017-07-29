package com.example.last_fm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.last_fm.R;
import com.example.last_fm.model.by_artist_and_album.AlbumByArtistAlbum;
import com.example.last_fm.model.by_artist_and_album.DataByArtistAlbum;
import com.example.last_fm.retrofit.ApiService;
import com.example.last_fm.retrofit.RestManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_for_album)
    protected Toolbar toolbar_for_album;
    @BindView(R.id.recycler_view_for_current_album)
    protected RecyclerView recycler_view_for_current_album;

    private ApiService apiService;

    private String artist_name;
    private String album_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        ButterKnife.bind(this);

        initHelpingClasses();
        getDataByIntent();
        initToolbar();
        // TODO initRecyclerView();
    }

    private void initHelpingClasses() {
        apiService = RestManager.getRetrofit(getApplicationContext());
    }

    private void getDataByIntent() {
        Intent intent = getIntent();
        artist_name = intent.getStringExtra("artist_name");
        album_name = intent.getStringExtra("album_name");
    }

    private void initToolbar() {
        setSupportActionBar(toolbar_for_album);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle(artist_name + " " + album_name);
    }

    private void initRecyclerView() {
        apiService.getDataByArtistAlbum(artist_name, album_name).enqueue(new Callback<DataByArtistAlbum>() {
            @Override
            public void onResponse(Call<DataByArtistAlbum> call, Response<DataByArtistAlbum> response) {
                DataByArtistAlbum dataByArtistAlbum = response.body();
                AlbumByArtistAlbum albumByArtistAlbum = dataByArtistAlbum.getAlbum();
                Toast.makeText(getApplicationContext(), albumByArtistAlbum.getUrl(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DataByArtistAlbum> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
